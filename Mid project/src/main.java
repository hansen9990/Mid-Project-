import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class main {
	 Scanner scan = new Scanner (System.in);
	 ArrayList <String> vNama = new ArrayList <> ();
	 ArrayList <String> vJabatan = new ArrayList <> ();
	 ArrayList <String> vJenis = new ArrayList <> ();
	 ArrayList <String> vKode = new ArrayList <> ();
	 ArrayList <Integer> vGaji = new ArrayList <> ();
	 Random rand = new Random ();
	 String nama, jenis, jabatan, kode = "";
	 int gaji;
	 
	 public main() {
		  int choose;
		  do {
		   System.out.println("PT Mentol");
		   System.out.println("=========");
		   System.out.println("1. Insert data karyawan");
		   System.out.println("2. View data karyawan");
		   System.out.println("3. Update data karyawan");
		   System.out.println("4. Delete data karyawan");
		   System.out.println("5. Exit");
		   do {
		    System.out.print("Choose : ");
		    choose = tryCatchNumber();
		   } while (choose < 1 || choose > 4);
		   
		   switch (choose) {
		   case 1:
		    insert();
		    break;

		   case 2:
		    view();
		    break;
		    
		   case 3:
		    update();
		    break;
		    
		   case 4:
		    delete();
		    break;
		    
		   case 5:
		    System.exit(0);
		    break;
		   
		   }
		  } while (choose != 5);
		  
		 }

		 public static void main(String[] args) {
		  new main();

		 }
		 
		 int tryCatchNumber() {
		  int temp = -1;
		  try {
		   temp = scan.nextInt(); scan.nextLine();
		  } catch (Exception e) {
		   System.out.println("Please put integer!");
		   scan.nextLine();
		  }
		  return temp;
		 }
		 
		 void insert() {
		  do {
		   System.out.print("Input nama karyawan [>= 3] : ");
		   nama = scan.nextLine();
		  } while (nama.length() < 3);
		  vNama.add(nama);
		  
		  do {
		   System.out.print("Jenis kelamin [Laki-laki / Perempuan] (Case sensitive) : ");
		   jenis = scan.nextLine();
		  } while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan"));
		  vJenis.add(jenis);
		  
		  kode = "";
		  for (int i = 1; i <= 2; i++) {
		   kode += (char)(rand.nextInt(26) + 65);
		  }
		  kode += "-";
		  for (int i = 1; i <= 4; i++) {
		   kode += rand.nextInt(10);
		  }
		  vKode.add(kode);
		  
		  do {
		   System.out.print("Jabatan karyawan [Manager / Supervisor/ Admin] (Case sensitive) : ");
		   jabatan = scan.nextLine();
		  } while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		  vJabatan.add(jabatan);
		  
		  if (jabatan.equals("Manager")) {
		   gaji = 80000000;
		  }
		  if (jabatan.equals("Supervisor")) {
		   gaji = 6000000;
		  }
		  if (jabatan.equals("Admin")) {
		   gaji = 4000000;
		  }
		  vGaji.add(gaji);
		  
		 }
		 
		 void view() {
		  if (vNama.isEmpty()) {
		   System.out.println("Tidak ada karyawan!");
		   System.out.println();
		  } else {
		   for (int i = 0; i < vNama.size() -1; i++) {
		    for (int j = i+1; j < vNama.size(); j++) {
		     if (vNama.get(i).compareTo(vNama.get(j)) > 0) {
		      String tempNama = vNama.get(i);
		      vNama.set(i, vNama.get(j));
		      vNama.set(j, tempNama);
		      
		      String tempKode = vKode.get(i);
		      vKode.set(i, vKode.get(j));
		      vKode.set(j, tempKode);
		      
		      String tempJenis = vJenis.get(i);
		      vJenis.set(i, vJenis.get(j));
		      vJenis.set(j, tempJenis);
		      
		      String tempJabatan = vJabatan.get(i);
		      vJabatan.set(i, vJabatan.get(j));
		      vJabatan.set(j, tempJabatan);
		      
		      int tempGaji = vGaji.get(i);
		      vGaji.set(i, vGaji.get(j));
		      vGaji.set(j, tempGaji);
		      
		     }
		    }
		   }
		   
		   for (int i = 0; i < vNama.size(); i++) {
		    System.out.println("No. " + (i+1));
		    System.out.println("Kode karyawan : " + vKode.get(i));
		    System.out.println("Nama karyawan : " + vNama.get(i));
		    System.out.println("Jenis kelamin : " + vJenis.get(i));
		    System.out.println("Jabatan : " + vJabatan.get(i));
		    System.out.println("Gaji karyawan : " + vGaji.get(i));
		    System.out.println("================================");
		    System.out.println();
		   }
		  }
		 }
		 
		 void update () {
		  int up;
		  
		  view();
		  System.out.println();
		  do {
		   System.out.print("Input angka yang ingin diupdate : ");
		   up = tryCatchNumber();
		  } while (up < vNama.size() || up > vNama.size() );
		  
		  do {
		   System.out.print("Input nama karyawan [>= 3] : ");
		   nama = scan.nextLine();
		  } while (nama.length() < 3);
		  vNama.set(up-1, nama);
		  
		  do {
		   System.out.print("Jenis kelamin [Laki-laki / Perempuan] (Case sensitive) : ");
		   jenis = scan.nextLine();
		  } while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan"));
		  vJenis.set(up-1, jenis);
		  
		  kode = "";
		  for (int i = 1; i <= 2; i++) {
		   kode += (char)(rand.nextInt(26) + 65);
		  }
		  kode += "-";
		  for (int i = 1; i <= 4; i++) {
		   kode += rand.nextInt(10);
		  }
		  vKode.set(up-1, kode);
		  
		  do {
		   System.out.print("Jabatan karyawan [Manager / Supervisor/ Admin] (Case sensitive) : ");
		   jabatan = scan.nextLine();
		  } while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		  vJabatan.set(up-1, jabatan);
		  
		  if (jabatan.equals("Manager")) {
		   gaji = 80000000;
		  }
		  if (jabatan.equals("Supervisor")) {
		   gaji = 6000000;
		  }
		  if (jabatan.equals("Admin")) {
		   gaji = 4000000;
		  }
		  
		  System.out.println();
		 }
		 
		 void delete() {
		  int hapus;
		  
		  view();
		  System.out.println();
		  do {
		   System.out.println("Input angka yang akan dihapus : ");
		   hapus = tryCatchNumber();
		  } while (hapus < vNama.size() || hapus > vNama.size());
		  vNama.remove(hapus-1);
		  vKode.remove(hapus-1);
		  vNama.remove(hapus-1);
		  vJenis.remove(hapus-1);
		  vJabatan.remove(hapus-1);
		  vGaji.remove(hapus-1);
		 }
}
