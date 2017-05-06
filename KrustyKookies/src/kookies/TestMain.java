package kookies;

import kookies.model.Database;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Database db = new Database();
		db.connect();
		db.getCookieList();
	}

}
