package com.zzang.test.top50.string;

import java.util.Stack;

public class LicenseKeyFormatting {
  public String solve(String str, int k) {
    //1. - del
    String newStr= str.replace("-", "");
    System.out.println("1: "+newStr);

    //2. upper
    newStr= newStr.toUpperCase();
    System.out.println("2: "+newStr);

    //3. k개로 파싱하기, 그리고 - 넣기
    StringBuilder sb = new StringBuilder(newStr);
    System.out.println("3: "+newStr);
//		"8F3Z2E9W"
    int len = sb.length();
    for(int i=k; i<len; i=i+k) {
      System.out.println("len-i: "+(len-i));
      sb.insert(len-i, '-');
      System.out.println("4: "+sb);
    }
    return sb.toString();
  }

  public String licenseKeyFormatting(String s, int k) {
    Stack<Character> chStack = new Stack<>();

    for (char ch: s.toCharArray()) {
      if ('-' != ch) {
        chStack.push(Character.toUpperCase(ch));
      }
    }

    StringBuilder sb = new StringBuilder();
    int index = 1;
    while (!chStack.empty()) {
      sb.append(chStack.pop());
      if ((index % k) == 0 && chStack.size() != 0) {
        sb.append('-');
      }
      index++;
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
//    String s = "5F3Z-2e-9-w";
    String s = "2-5g-3-J";
    int k = 2;

    LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
    String res = licenseKeyFormatting.licenseKeyFormatting(s, k);

    System.out.println("res: " + res);
  }

}
