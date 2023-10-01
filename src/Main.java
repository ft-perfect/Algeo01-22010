import java.util.Scanner;
@SuppressWarnings("unused")

public class Main { 
    public static void main(String[] args){ // seriously? perlu kujelasin?
		Scanner sc = new Scanner(System.in);
        boolean exit = false;
		int input;
		
        while(!exit){
            input = home(sc);
			switch(input){
				case 1:
					splHome(sc);
					break;
				case 2:
					detHome(sc);
					break;
				case 3:
					inverseHome(sc);
					break;
				case 4:
					interpolasiPolinomHome(sc);
					break;
				case 5:
					interpolasiBicubicHome(sc);
					break;
				case 6:
					linearRegHome(sc);
					break;
				case 7:
					System.out.println("Have a good day! ^_^");
					exit = true;
					break;
			}
        } 
		sc.close();
    }

	public static int home(Scanner sc){ // ini home menu nya
		System.out.print("MENU : \n1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks Balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic Spine\n6. Regresi Linier Berganda\n7. Keluar\nMasukkan pilihan(1-7):");

		int input = cinCheck(sc, 1, 7);
		return input; // di sini udah sukses inputnya (valid)
	}

	public static void splHome(Scanner sc){ // buat SPL gan
		int input = 0;
		boolean exit = false;
		
		while (exit == false){
			System.out.println("SISTEM PERSAMAAN LINEAR\n1. Metode eliminasi Gauss\n2. Metode eliminasi Gauss-Jordan\n3. Metode matriks balikan\n4. Kaidah cramer\n5. Kembali");
			System.out.print("Silahkan pilih metode atau pilihan menu: "); 
			input = cinCheck(sc, 1, 5);
			System.out.println("Opsi " + input + " telah dipilih.");
			switch (input){
				case 1:
					Matrix m1 = InputMatrixSPL(sc);
					// gauss
					break;
				case 2:
					Matrix m2 = InputMatrixSPL(sc);
					// gauss-jordan
					break;
				case 3:
					Matrix m3 = InputMatrixSPL(sc);
					// metoda inverse
					break;
				case 4:
					Matrix m4 = InputMatrixSPL(sc);
					// metoda cramer
					break;
				case 5:
					exit = true;
					break;
			}
		}
	}

	public static void detHome(Scanner sc){ // buat determinan gan
     	System.out.println("Menu Determinan telah dipilih");

		Matrix m = InputMatrix(sc);
		// di sini panggil determinan,
	}

	public static void inverseHome(Scanner sc){ // buat matriks balikan gan
		System.out.println("Menu Matriks Balikan telah dipilih");

		Matrix m = InputMatrix(sc);
		// di sini panggil fungsi inverse

	}

	public static void interpolasiPolinomHome(Scanner sc){ // buat interpolasi polinom gan
		System.out.println("Menu Interpolasi Polinom telah dipilih");

		Matrix m = InputMatrix(sc);
		// di sini panggil fungsi interpolasi polinom
	}

	public static void interpolasiBicubicHome(Scanner sc){ // buat interpolasi bicubic gan
		System.out.println("Menu Interpolasi Bicubic Spine telah dipilih");

		Matrix m = InputMatrix(sc);
		// di sini panggil fungsi interpolasi bicubic
	}

	public static void linearRegHome(Scanner sc){ // buat regresi linear gan
		System.out.println("Menu Regresi Linear Berganda telah dipilih");

		Matrix m = InputMatrix(sc);
		// di sini panggil fungsi regresi linear
	}



	// fungsi2 buat primitif
	public static Matrix InputMatrixSPL(Scanner sc){ //ini buat input matrix gan.
		Matrix m = new Matrix(0, 0);

		System.out.println("Silahkan Input Matrix yang akan diolah");
		System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
		int input = cinCheck(sc, 1, 2);
		switch (input){

			case 1:
				System.out.println("Masukkan pilihan input: \n(1) Format Ax = B \n(2) Format Matriks Augmented");
				int input1 = cinCheck(sc, 1, 2);
				switch (input1){
					case 1:
						System.out.print("Masukkan ukuran baris dari matriks A: "); int row = sc.nextInt();
						System.out.print("Masukkan ukuran kolom dari matriks A: "); int col = sc.nextInt();

						System.out.println("Masukkan matriks A: ");
						Matrix A = new Matrix(row, col); A.readMatrix(sc);

						Matrix B = new Matrix(row, 1);
						System.out.println("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
						B.readMatrix(sc);
						
						m = new Matrix(row, col+1);
						for (int i = 0; i < row; i++){
							for (int j = 0; j< col; j++){
								m.set(i, j, A.elmt(i, j));
							}
						} for (int i = 0; i < row; i++){
							m.set(i, col, B.elmt(i, 0));
						} 

						break;
					case 2:
						System.out.print("Masukkan ukuran baris dari matriks: ");	int row2 = sc.nextInt();
						System.out.print("Masukkan ukuran kolom dari matriks: "); int col2 = sc.nextInt();
						m = new Matrix(row2, col2);

						System.out.println("Masukkan matriks: ");
						m.readMatrix(sc);
						
						break;
				} break;

			case 2:
				m = TXTReaderWriter.readTXT();
				break;

		} return m;
	}

	public static Matrix InputMatrix(Scanner sc){ //ini buat input matrix gan.
		Matrix m = new Matrix(0, 0);

		System.out.println("Silahkan Input Matrix yang akan diolah");
		System.out.println("Masukkan pilihan input: (1) untuk input dari keyboard, dan (2) untuk input dari file.txt");
		int input = cinCheck(sc, 1, 2);
		switch (input){

			case 1:
				System.out.print("Masukkan ukuran baris dari Matriks: ");	int row = sc.nextInt();
				System.out.print("Masukkan ukuran kolom dari Matriks: "); int col = sc.nextInt();
				m = new Matrix(row, col);

				System.out.println("Masukkan Matriks berukuran baris x kolom sesuai input sebelumnya");
				m.readMatrix(sc);

				break;

			case 2:
				m = TXTReaderWriter.readTXT();
				break;

		} return m;
	}

	public static int cinCheck(Scanner sc, int a, int b){ // ini buat input yang ada constrain nya
		int input = sc.nextInt(); 
		while((input<a)||(input>b)){
			System.out.print("Input tidak valid, silahkan input kembali: "); input = sc.nextInt();
		} return input;
	}
}