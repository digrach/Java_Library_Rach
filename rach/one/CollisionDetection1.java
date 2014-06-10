package rach.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollisionDetection1 extends Thread {

	private int mCanvasWidth;  
	private int mCanvasHeight;  

	private final List<Particle> particles = new ArrayList<Particle>();
	private List<Particle>[] checkList;
	private int particleSize = 10;


	int maxParticleSize;

	@Test
	public void mainLoop() {
		mCanvasWidth = 200;
		mCanvasHeight = 200;
		maxParticleSize = particleSize * 6;

		for (int x = 0; x < 50; x++){
			checkList = new List[mCanvasHeight];
			addParticles();
			updateParticles();
			checkForColision();
		}
	}

	@Test
	public void checkForColision() {
		for (int j = 0; j < particles.size(); j++) {
			Particle p = particles.get(j);
			// Field to scan is the Particle's current y +/- max size.
			int startRowIndex = (int) (p.getPosy() - maxParticleSize);
			if (startRowIndex < 0) {
				startRowIndex = 0;
			}
			int endRowIndex = (int) (p.getPosy() + maxParticleSize);
			if (endRowIndex > checkList.length - 1) {
				endRowIndex = checkList.length - 1;
			}
			for (int x = startRowIndex; x <= endRowIndex; x ++) {
				List<Particle> l = checkList[x]; 
				if (l != null) { 
					for (int i = 0; i < l.size(); i++ ) { 
						Particle cp = l.get(i);

						if (p != cp) {

							Particle smaller = p;
							Particle larger = cp;

							if (p.getSize() > cp.getSize()) {
								larger = p;
								smaller = cp;
							} 

							if (smaller.getPosx() + smaller.getSize() >= larger.getPosx()
									&& smaller.getPosx() <= larger.getPosx() + larger.getSize()
									&& smaller.getPosy() + smaller.getSize() >= larger.getPosy()
									&& smaller.getPosy() <= larger.getPosy() + larger.getSize()) {

								assertTrue(smaller.getPosx() + smaller.getSize() >= larger.getPosx()
										&& smaller.getPosx() <= larger.getPosx() + larger.getSize()
										&& smaller.getPosy() + smaller.getSize() >= larger.getPosy()
										&& smaller.getPosy() <= larger.getPosy() + larger.getSize());
								
								System.out.println(particles.size());
								
								p.setSize(maxParticleSize);
								l.get(i).setSize(maxParticleSize);

							}
						} 
					}
				}
			}
		}
	}

	private void updateParticles() {
		for (int x = 0; x < particles.size(); x++) {
			particles.get(x).update();

			if (checkList[(int)particles.get(x).getPosy()] == null) {
				checkList[(int)particles.get(x).getPosy()] = new ArrayList<Particle>();
			}
			checkList[(int)particles.get(x).getPosy()].add(particles.get(x));
		}
	}

	private void addParticles() {
		for (int z = 0; z < 20; z ++) {
			Random r = new Random();
			int randomx = r.nextInt((int) (mCanvasWidth));
			int randomy = r.nextInt((int) (mCanvasHeight));
			int randomTargetx = r.nextInt((int) (mCanvasWidth));
			int randomTargety = r.nextInt((int) (mCanvasHeight));
			Particle p = new Particle(randomx, randomy, randomTargetx, randomTargety, particleSize, 0, mCanvasHeight);
			particles.add(p);
		}
	}



	//	@Test
	//	public void checkForColision1() {
	//
	//		for (int z = 0; z < 100; z ++) {
	//			Random r = new Random();
	//			int randomx = r.nextInt((int) (mCanvasWidth +1));
	//			int randomy = r.nextInt((int) (mCanvasHeight +1));
	//			int randomTargetx = r.nextInt((int) (mCanvasWidth +1));
	//			int randomTargety = r.nextInt((int) (mCanvasHeight +1));
	//			Particle p = new Particle(randomx, randomy, randomTargetx, randomTargety, particleSize, 0, mCanvasHeight);
	//			particles.add(p);
	//		}
	//
	//		int mCanvasHeight = 200;
	//
	//		maxParticleSize = particleSize * 6;
	//		checkList = new List[mCanvasHeight];
	//
	//		for (int x = 0; x < particles.size(); x++) {
	//			particles.get(x).update();
	//
	//			if (checkList[(int)particles.get(x).getPosy()] == null) {
	//				checkList[(int)particles.get(x).getPosy()] = new ArrayList<Particle>();
	//			}
	//			checkList[(int)particles.get(x).getPosy()].add(particles.get(x));
	//		}
	//
	//		boolean collision = false;
	//
	//		for (int j = 0; j < particles.size(); j++) {
	//
	//			Particle p = particles.get(j);
	//
	//			int startRowIndex = (int) (p.getPosy() - maxParticleSize);
	//			if (startRowIndex < 0) {
	//				startRowIndex = 0;
	//			}
	//			int endRowIndex = (int) (p.getPosy() + maxParticleSize);
	//			if (endRowIndex > checkList.length - 1) {
	//				endRowIndex = checkList.length - 1;
	//			}
	//			for (int x = startRowIndex; x <= endRowIndex; x ++) {
	//				List<Particle> l = checkList[x]; 
	//				if (l != null) { 
	//					for (int i = 0; i < l.size(); i++ ) { 
	//						Particle cp = l.get(i);
	//
	//						if (p != cp) {
	//
	//							int xd = (int) Math.abs(p.getPosx() - cp.getPosx() + cp.getSize());	
	//							int yd = (int) Math.abs(p.getPosy() - cp.getPosy() + cp.getSize());					
	//
	//							int w = (int) (p.getSize() + cp.getSize());
	//							int h = (int) (p.getSize() + cp.getSize());
	//
	//							if (xd<= w && yd <= h) {
	//
	//								assertTrue(xd<= w && yd <= h);
	//
	//								p.setSize(maxParticleSize);
	//								cp.setSize(maxParticleSize);
	//								collision = true;						
	//							}
	//						}
	//					}
	//				}
	//			}
	//		}
	//	}



}
