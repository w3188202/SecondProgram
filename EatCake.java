import java.util.ArrayList;
import java.util.Scanner;

public class EatCake {
/*	public class DiguiCake {
		public static int fun1(int n) {
			int sum= 0;
			if(n==1) {
				sum=1;
			}else if(n==2){
				sum=2;
			}else if(n==3) {
				sum=4;
			}else {
				sum=fun1(n-1)+fun1(n-2)+fun1(n-3);
			}
			return sum;
		}
		public static String[] fun2(int n) {
			String[] sum = new String[fun1(n)];
			if(n==1) {
				sum[0]= "1,";
			}else if(n==2){
				sum[0]="1,1,";
				sum[1]="2,";
			}else if(n==3) {
				sum[0]="1,1,1,";
				sum[1]="1,2,";
				sum[2]="2,1,";
				sum[3]="3,";
			}else {
				for(int i =0;i<fun1(n-3);i++) {
					sum[i]=fun2(n-3)[i]+"3,";
				}
				for(int i =fun1(n-3);i<(fun1(n)-fun1(n-1));i++) {
					sum[i]=fun2(n-2)[i-fun1(n-3)]+"2,";
				}
				for(int i =(fun1(n)-fun1(n-1));i<fun1(n);i++) {
					sum[i]=fun2(n-1)[i-(fun1(n)-fun1(n-1))]+"1,";
				}
			}
			return sum;
		}
		
		public static void main(String[] args) {
			System.out.println("请输入有多少个蛋糕");
			Scanner in = new Scanner(System.in);
			int n=in.nextInt();
			System.out.println("总吃饭数为："+fun1(n)+"种\t分别为： ");
			for(int i =0;i<fun2(n).length;i++) {
				System.out.println(fun2(n)[i]);
			}
		}

	}*/
	
	
	
	
	public static int fun(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}
		return fun(n-3)+fun(n-2)+fun(n-1);
	}
	
	public static ArrayList<StringBuilder> print1(int n) {
		ArrayList<StringBuilder> list = new ArrayList<>();
		if(n==1) {
			list.add(new StringBuilder("1,"));
		}else if(n==2){
			list.add(new StringBuilder("1,1,"));
			list.add(new StringBuilder("2,"));
		}else if(n==3) {
			list.add(new StringBuilder("1,1,1,"));
			list.add(new StringBuilder("1,2,"));
			list.add(new StringBuilder("2,1,"));
			list.add(new StringBuilder("3,"));
		}else {
			list.addAll(print1(n-3));
			list.addAll(print1(n-2));
			list.addAll(print1(n-1));
			for(int i=0;i<fun(n);i++) {
				if(i<fun(n-3)) {
					list.get(i).append("3,");
				}else if(i>=fun(n-3)&&i<(fun(n-2)+fun(n-3))) {
					list.get(i).append("2,");
				}else {
					list.get(i).append("1,");
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("****请输入蛋糕总数：");
		int n = in.nextInt();
		System.out.println("吃饭总数： "+fun(n)+" 种   分别为");
		print1(n).forEach(x->{
			System.out.println(x.toString());
		});
	}
}
