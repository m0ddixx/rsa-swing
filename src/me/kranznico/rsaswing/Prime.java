package me.kranznico.rsaswing;

import java.math.BigInteger;
import java.util.ArrayList;

import java.security.SecureRandom;;

public class Prime {
	
	private static String globalRange = "100000000000000000000000000000000000000000000000000000000000000000";

	public static ArrayList<BigInteger> factorizePrime(BigInteger number) {

		ArrayList<BigInteger> returnval = new ArrayList<BigInteger>();
		BigInteger i; 
		BigInteger count;

		for (i = new BigInteger("2"); i.compareTo(number.add(BigInteger.ONE)) <0; i = i.add(BigInteger.ONE))
		{
			count=BigInteger.ZERO;
			while(number.remainder(i) == BigInteger.ZERO )
			{
				number=number.divide(i); 
				count=count.add(BigInteger.ONE);
			}
			if(count.equals(BigInteger.ZERO)) continue;
			returnval.add(i);
		}
		return returnval;
	}

	public static BigInteger generate(String range) {
		BigInteger r;
		BigInteger n = new BigInteger(range);
		do {
		    r = new BigInteger(n.bitLength(), 500000, new SecureRandom());
		} while (r.compareTo(new BigInteger(range)) != -1);
		
		return r;
	}
	
	public static BigInteger generate() {
		BigInteger r;
		BigInteger n = new BigInteger(globalRange);
		    r = new BigInteger(n.bitLength(), 500000, new SecureRandom());
		
		return r;
	}

	public static String getGlobalRange() {
		return globalRange;
	}

	public static void setGlobalRange(String globalRange) {
		Prime.globalRange = globalRange;
	}

}
