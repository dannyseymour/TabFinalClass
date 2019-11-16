package edu.cnm.deepdive.tabfinalclass.controller.fragment;

public class ContentItem {
  final String name;
  final String desc;
  boolean isSection =false;

  public ContentItem(String name) {
    this.name = name;
    this.desc ="";
    this.isSection = true;
  }

  public ContentItem(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }
}
