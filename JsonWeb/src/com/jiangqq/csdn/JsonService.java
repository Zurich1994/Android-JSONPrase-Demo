package com.jiangqq.csdn;

import java.util.ArrayList;
import java.util.List;

import com.jiangqq.bean.Person;

public class JsonService {
	public static List<Person> getListPerson() {
		List<Person> mLists = new ArrayList<Person>();
		mLists.add(new Person("����", "����", 20));
		mLists.add(new Person("����", "�Ϻ�", 30));
		mLists.add(new Person("����", "����", 35));
		return mLists;
	}
}
