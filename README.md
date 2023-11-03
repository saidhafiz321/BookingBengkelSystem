# BookingBengkelPadepokan79

Fitur Login						
Agar dapat memasuki aplikasi Booking Bengkel, maka harus dapat Login menggunakan CustomerId dan Password.						
Jika CustomerId dan Password Sesuai maka akan masuk ke Home Menu Aplikasi Booking Bengkel.						
Jika CustomerId tidak Tersedia atau Tidak Ditemukan, maka akan mengeluarkan Notifikasi Bahwa "Customer Id Tidak Ditemukan atau Salah!"						
Jika Password Salah, maka akan mengeluarkan Notifikasi Bahawa "Password yang anda Masukan Salah!"						
Jika terjadi kesalahan dalam memasukan Customer Id atau Password sebanyak "Tiga Kali", maka Aplikasi Akan berhenti atau Exit.						
						
Fitur Informasi Customer/Profile						
Fitur untuk menampilkan Informasi data Customer/Profile yang sama saat Login. Contoh Ketika di awal Login menggunakan Cust-001, maka Data yang ditampilkan adalah keseluruhan Data Cust-001.						
Data yang harus ditampilkan pada Fitur Informasi Customer/Profile adalah:						
Customer Id						
Nama						
Customer Sattus (Member / Non Member)						
Alamat						
Saldo Koin (Hanya untuk Member)						
List Kendaraan						
						
						
Fitur Booking Bengkel						
Fitur untuk booking service Bengkel yang dapat Customer Lakukan.						
Customer Harus memilih terlebih dahulu Kendaraan yang akan di Service, dari list kendaraan yang dia punya berdasarkan "Vehicle Id".						
Ketika Customer memasukan Vehicle Id:						
Jika Vehicle Id tidak ditemukan pada list Kendaraan customer, maka akan memberikan "Notifikasi Pesan bahwa Kendaraan Tidak ditemukan.".						
"Jika Vehicle Id ditemukan pada list Kendaraan customer, maka akan Menampilkan List Item Service yang dapat dipilih untuk Kendaraan tersebut, 
berdasarkan Tipe Kendaraannya (Vehicle Type Classnya). Misalkan Car atau Motorcyle."						
						
"Setelah itu customer dapat memilih service item yang ingin dilakukan untuk kendaraan tersebut. Tetapi untuk Jumlah service yang dapat dilakukan dalam satu kali Booking berbeda.
Yaitu berdasarkan Status Customer apakah Member atau Non Member."						
Jumlah Service Untuk Non Member adalah maksimal 1 item Service.						
Jumlah Service Untuk Member adalah maksimal 2 item Service.						
						
Setelah itu Customer memilih Metode Pembayaran:						
Untuk Customer Member dapat memilih 2 Metode yaitu Saldo Coin, atau Cash.						
Untuk Customer Non Member dapat memilih 1 Metode yaitu Cash.						
Payment dengan metode Saldo Coin akan mendapatkan diskon sebesar 10% dari total Service yang dipilih.						
Payment dengan metode Cash Tidak mendapatkan diskon.						
"Jika Customer Member, membayar menggunakan metode Saldo Coin. Maka Saldo Coin yang ada di data Customer Member tersebut akan berkurang 
Sesuai dengan jumlah Item Service yang harus dibayar (Payment). (Hanya Berlaku Untuk Member)"						
						
Fitur Top Up Saldo Coin						
Fitur untuk menambahkan Saldo Coin.						
Fitur ini hanya dapat dilakukan oleh Customer Member Saja.						
Jika Fitur ini diakses oleh Customer Non Member, maka akan menampilkan Notifikasi Pesan "Maaf fitur ini hanya untuk Member saja!".						
						
Fitur Informasi Booking						
Fitur ini akan menampilkan semua Booking Order yang pernah dilakukan Oleh customer yang melakukan Login.						
Data yang harus ditampilkan pada Fitur Informasi Booking adalah:						
Booking Id						
Nama Customer						
List Service						
Payment Method						
Total Service Price						
Total Payment						
Booking Date						
						
						
Fitur Logout						
Fitur ini ketika dipilih maka akan kembali ke Menu Awal Aplikasi Berjalan. (Start Menu)						
						
						
Logic						
Silahkan tambahkan logic untuk semua fitur di class yang ada pada package Services. 						
BengkelService						
MenuService						
PrintService						
Validation						
						
						
Catatan						
Boleh menambahkan Class, method/function, serta variable lainnya diluar template Sesuai dengan Kebutuhan.						
