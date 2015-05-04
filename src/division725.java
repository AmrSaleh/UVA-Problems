import java.util.Scanner;

public class division725 {

	public static void main(String[] args) {
		int n, p;
		int[] number = new int[5];

		String x, ops;
		boolean[] digits = new boolean[10];
		long u;
		boolean correct = true;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		while (n != 0) {

			p = 0;

			for (int a = 0; a < 5; a++) {

				for (int i = 0; i < digits.length; i++) {
					digits[i] = false;
				}

				number[0] = a;

				digits[a] = true;
				for (int b = 0; b < 10; b++) {
					if (digits[b] == true) {
						continue;
					} else {
						number[1] = b;
						digits[b] = true;
						for (int c = 0; c < 10; c++) {
							if (digits[c] == true) {
								continue;
							} else {
								number[2] = c;
								digits[c] = true;
								for (int d = 0; d < 10; d++) {
									if (digits[d] == true) {
										continue;
									} else {
										number[3] = d;
										digits[d] = true;
										for (int e = 0; e < 10; e++) {
											if (digits[e] == true) {
												continue;
											} else {
												number[4] = e;
												digits[e] = true;

												u = number[4] + 10 * number[3] + 100 * number[2] + 1000 * number[1] + 10000 * number[0];

												x = (u * n) + "";

												correct = true;
												ops = "";
												if (x.length() == 5 || x.length() == 4) {

													for (int k = 0; k < x.length(); k++) {
														if (x.length() == 4 && u < 10000) {
															correct = false;
															break;

														}
														if (digits[Integer.parseInt(x.charAt(k) + "")] == false) {
															digits[Integer.parseInt(x.charAt(k) + "")] = true;
															ops = ops + x.charAt(k);

														} else {
															correct = false;
															break;
														}

													}
													for (int o = 0; o < ops.length(); o++) {
														digits[Integer.parseInt(ops.charAt(o) + "")] = false;
													}
													if (correct == true) {
														if (x.length() == 4) {
															System.out.print("0");
														}
														System.out.print(x + " / ");
														if (u < 10000) {
															System.out.print("0");
														}
														System.out.println(u + " = " + n);
														p++;
													}
												}
												digits[e] = false;
											}

										}
										digits[d] = false;
									}

								}
								digits[c] = false;
							}

						}
						digits[b] = false;
					}

				}
				digits[a] = false;
			}
			if (p == 0) {
				System.out.println("There are no solutions for " + n + ".");
			}

			n = input.nextInt();

			if (n != 0) {
				System.out.println();
			}

		}

		input.close();
	}

}
