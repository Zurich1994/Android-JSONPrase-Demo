package com.jiangqq.csdn;

import java.util.ArrayList;
import java.util.List;

import com.jiangqq.bean.Person;

public class JsonService {
	public static List<Person> getListPerson() {
		List<Person> mLists = new ArrayList<Person>();
		mLists.add(new Person("张三", "北京", 20));
		mLists.add(new Person("李四", "上海", 30));
		mLists.add(new Person("王五", "深圳", 35));
		return mLists;
	}
}
