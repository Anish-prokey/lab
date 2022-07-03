package question7;

import java.util.Comparator;

public  class BookCompare implements Comparator<Book>{
	
	public int compare(Book b1,Book b2) {
		return (int)(b1.price-b2.price);
	}

}


public class Book {
	String title,author,pub;
	double price;
	
	Book(String title,String author,String pub,Double price){
	    this.title=title;
	    this.author=author;
	    this.pub=pub;
	    this.price=price;
	}
	


	public String toString() {
		String str="title is "+title+" author is "+author+" publis is  "+pub+" price is  "+price;
		return str;
	}

}


import java.util.*;

public class mainclass {
	static Scanner sc=new Scanner(System.in);
	static HashMap<Integer,Book> hm=new HashMap<Integer,Book>();
	
	static void createHashMap(ArrayList<Book> ba) {
		int i=1;
		for(Book b1:ba) {
			hm.put(i,b1);
			i++;
		}
	}
	
	
	static void readdata(ArrayList<Book> barr) {
		
	while(true) {
		System.out.println("enter yes or no");
		String cho=sc.next();
		if(cho.equals("yes")) {
		System.out.println("enter book details");
		System.out.println("enter title");
		String title=sc.next();
		System.out.println("enter authoe name");
		String author=sc.next();
		System.out.println("enter pub name");
		String pub=sc.next();
		System.out.println("enter price");
		Double price=Double.parseDouble(sc.next());
		Book b1=new Book(title,author,pub,price);
		barr.add(b1);
		}
		else {
			break;
		}
	}
	}
	
	public static void main(String args[]) {
	  ArrayList<Book> al= new ArrayList<Book>();
	  readdata(al);
	  System.out.println(al);
	  ArrayList<Book> sl=(ArrayList<Book>)al.clone();
	  sl.sort(new BookCompare());
	  System.out.println(sl);
	  createHashMap(al);
	  System.out.println(hm);
	  
	  System.out.println();
	  System.out.println("enter auth name");
	  String au=sc.next();
	  for(Map.Entry<Integer,Book> s:hm.entrySet()) {
	    Book bb=s.getValue();
	    if(au.equals(bb.author)) {
	    	System.out.println(s.getValue());
	    }
	}
	  
	  LinkedList<Book> ll=new LinkedList<Book>();
	  System.out.println("enter price");
	  Double pr=Double.parseDouble(sc.next());
	  for(Map.Entry<Integer,Book> b12:hm.entrySet()) {
		  Book b123=b12.getValue();
		  if(b123.price>pr) {
			  ll.add(b123);
		  }
	  }
	  for(Book bbb:ll) {
		  System.out.println(bbb);
	  }
	  System.out.println("enter pub name");
	  String au1=sc.next();
	  for(Map.Entry<Integer,Book> s:hm.entrySet()) {
	    Book bb=s.getValue();
	    if(au1.equals(bb.pub)) {
	    	System.out.println(s.getValue());
	    }
	}
	  System.out.println("enter title to be updated");
	  String titl=sc.next();
	  for(Map.Entry<Integer,Book> ss:hm.entrySet()) {
		  Book s2=ss.getValue();
		  if(s2.title.equals(titl)) {
			  System.out.println("enter pub name to be updates");
			  String pub1=sc.next();
			  s2.pub=pub1;
		  }
		  
	  }
	  System.out.println(hm);
	  
	  
     System.out.println("enter part of publishers name");
     String p=sc.next();
     for(Map.Entry<Integer,Book> s:hm.entrySet()) {
    	 Book b1=s.getValue();
    	 if(b1.pub.contains(p)) {
    		 System.out.println(s.getValue());
    	 }
     }
	  
}
}