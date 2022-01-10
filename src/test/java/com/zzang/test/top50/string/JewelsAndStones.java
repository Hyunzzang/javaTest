package com.zzang.test.top50.string;

public class JewelsAndStones {

//  public int numJewelsInStones(String jewels, String stones) {
//    int count = 0;
//    for (char jewel: jewels.toCharArray()) {
//      for (char stone: stones.toCharArray()) {
//        if (jewel == stone) count++;
//      }
//    }
//
//    return count;
//  }

  public int numJewelsInStones(String jewels, String stones) {
    int result = 0;
    int[] j = new int[52];
    int[] s = new int[52];

    for(char c : jewels.toCharArray()){
      if(Character.isLowerCase(c))
        j[c-'a']++;
      else
        j[c-'A'+26]++;

    }
    for(char c : stones.toCharArray()){
      if(Character.isLowerCase(c))
        s[c-'a']++;
      else
        s[c-'A'+26]++;

    }

    for(int i = 0; i < 52; i++){
      if(j[i] != 0){

        if(s[i] != 0){
          result += s[i];
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    String jewels = "aA", stones = "aAAbbbb";
    String jewels = "z", stones = "ZZ";

    JewelsAndStones jewelsAndStones = new JewelsAndStones();
    int res = jewelsAndStones.numJewelsInStones(jewels, stones);

    System.out.println("res: " + res);
  }

}
