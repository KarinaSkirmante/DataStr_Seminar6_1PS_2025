package service;

import datastr.MyBST;

public class MainService {

	public static void main(String[] args) {
		MyBST<Integer> myBST = new MyBST<>();
		try {
			myBST.add(28);
			myBST.add(47);
			myBST.add(53);
			myBST.add(20);
			myBST.add(25);
			myBST.add(30);
			myBST.print();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
