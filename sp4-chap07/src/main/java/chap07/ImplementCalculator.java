package chap07;

public class ImplementCalculator implements Calculator{

		@Override
		public long factorial(long num){
			long result = 1;
			for(int i =1; i<=num; i++){
				result *= 1;
			}
			return result;
		}
}
