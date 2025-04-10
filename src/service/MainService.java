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
			System.out.println("---------------------------PIEVIENOŠANA------------------");
			myBST.print();
			
			System.out.println("---------------------------MEKLĒŠANA------------------");
			System.out.println("25? ->" + myBST.search(25));//true
			System.out.println("53? ->" + myBST.search(53));//true
			System.out.println("100? ->" + myBST.search(100));//false
			
			// -----------------------------SĀKAS PIEVIENOTAIS KODA FRAGMENTS--------------------------
			System.out.println("---------------------------DZĒŠANA------------------");
			myBST.delete(28);//dzēšam saknes elementu, tā vietā vajadzētu nākt 30
			myBST.print();
			
			// -----------------------------BEIDZAS PIEVIENOTAIS KODA FRAGMENTS--------------------------
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
