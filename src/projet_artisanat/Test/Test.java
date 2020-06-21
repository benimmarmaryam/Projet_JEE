package projet_artisanat.Test;

import projet_artisanat.Models.CategorieEntity;
import projet_artisanat.ServicesImpl.CategorieServiceImpl;

public class Test {

	public static void main(String[] args) {
		CategorieServiceImpl catServiceImpl = new CategorieServiceImpl();
		System.out.println("Result");
		System.out.println(catServiceImpl.findById(1).getCatlib());
		for(CategorieEntity cat: catServiceImpl.findAll()) {
			System.out.println(cat);
		}

	}

}
