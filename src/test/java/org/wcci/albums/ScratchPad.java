package org.wcci.albums;

import org.junit.Test;

public class ScratchPad extends Exception {

	
	@Test
	public void testName() {
		System.out.println("Having fun");
		//try {
		if(1!-1) {
			throw new ScratchPadException("Not having fun!");
		}
		//}catch(ScratchPadException e){
			//System.out.println(e.getMessage());
		//}
	}
	
	
	
	public class ScratchPadException extends RuntimeException {
		
		public ScratchPadException(String string) {
			super(string);
		}
	}
}
