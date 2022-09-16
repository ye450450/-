package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
	ArrayList<Word> list;
	Scanner s;
	
	WordCRUD(Scanner s){
		list = new ArrayList<>();
		this.s = s;//이렇게만 작성해도 되는구나? Scanner s = new Scanner(System.in)과는 뭐가 다르지?
	}
	@Override
	public Object add() {
		System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine();
		// 1 deriveway
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();
		// 차고 진입로
		
		return new Word(0,level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("\n새 단어가 단어장에 추가되었습니다.\n");
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}
	public void listAll() {
		System.out.println("-----------------------------");
		for(int i =0;i<list.size();i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("-----------------------------");
	}
	public ArrayList<Integer> listAll(String s) {
		int j=0;
		ArrayList<Integer> num= new ArrayList<>();
		System.out.println("-----------------------------");
		for(int i =0;i<list.size();i++) {
			String word = list.get(i).getWord();
			if(word.contains(s)){
			System.out.print((j+1) + " ");
			System.out.println(list.get(i).toString());
			num.add(i);
			j++;
			}
		}
		
		System.out.println("-----------------------------");
		return num;
	}
	
	public void updateItem() {
		System.out.print("=> 수정할 단어 검색 : ");
		String keyword = s.nextLine();//수정할 단어가 포함되어 있는 단어를 입력받음
		ArrayList<Integer> snum= this.listAll(keyword);
		System.out.print("=> 수정할 번호 검색 : ");
		s.nextInt();
		String nothing = s.nextLine();
		System.out.print("=> 뜻 입력 : ");
		String meaning = s.nextLine();
		list.get(snum.get(num-1)).setMeaning(meaning);
		System.out.println("단어가 수정되었습니다.");
	}
	public void deleteItem() {
		System.out.print("=> 삭제할 단어 검색 : ");
		String keyword = s.nextLine();//수정할 단어가 포함되어 있는 단어를 입력받음
		ArrayList<Integer> snum= this.listAll(keyword);
		System.out.print("=> 삭제할 번호 검색 : ");
		s.nextInt();
		String nothing = s.nextLine();
		System.out.print("=> 정말로 삭제하실래요?(Y/N) ");
		String meaning = s.nextLine();
		if(meaning.equalsIgnoreCase("y"))
		list.remove((int)snum.get(num-1));
		System.out.println("단어가 수정되었습니다.");
	}
	
}
