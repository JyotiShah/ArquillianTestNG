package com.company.module.testFramework.helper.genericHelper;

import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.WebElement;

public class MenuHover {

	public static void TwoLevelMenuHover(WebElement menuName, WebElement subMenuName) {
		Graphene.waitModel().until().element(menuName).is().clickable();
		menuName.click();
		Graphene.waitModel().until().element(subMenuName).is().clickable();
		subMenuName.click();
	}

	public static void ThreeLevelMenuHover(WebElement menuName, WebElement subMenuName, WebElement subMenuofSubMenu) {
		Graphene.waitModel().until().element(menuName).is().clickable();
		menuName.click();
		Graphene.waitModel().until().element(subMenuName).is().clickable();
		subMenuName.click();
		Graphene.waitModel().until().element(subMenuofSubMenu).is().clickable();
		subMenuName.click();
	}
}
