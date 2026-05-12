# 📱 Tugas 2 - Pemrograman Mobile  
## 🎬 MovieVerse  
### Aplikasi Katalog Film Android    

---

### 📌 Deskripsi
MovieVerse merupakan aplikasi Android sederhana bertema katalog film modern yang dibuat menggunakan **Kotlin** dan **XML Layout** di Android Studio.

Aplikasi ini memungkinkan pengguna untuk mencari film, memfilter berdasarkan kategori tertentu, melakukan sorting, melihat detail film, menandai film favorit, serta melihat informasi lengkap seperti rating, cast, director, durasi, dan deskripsi film.

Project ini dibuat sebagai implementasi pembelajaran **Pemrograman Mobile Android** menggunakan komponen modern Android seperti **RecyclerView**, **Intent**, dan **Custom Adapter**.

Aplikasi ini dibuat sebagai bagian dari **Tugas 2 Pemrograman Mobile Kelas A**.

---

### 👤 Identitas Mahasiswa
- **Nama** : I Gusti Bagus Narendratanaya Wiweka  
- **NIM**  : 2405551007  

---

### 🛠️ Teknologi yang Digunakan
- Kotlin  
- Android Studio  
- XML Layout  
- RecyclerView  
- CardView  
- Intent Navigation  
- Material Design Components

---

### 🎯 Fitur Aplikasi
- 🔍 Search film berdasarkan judul
- 🎭 Filter film berdasarkan genre
- 📅 Filter film berdasarkan tahun
- ⭐ Filter film berdasarkan rating
- ❤️ Favorite movie feature
- 📊 Sorting:
  - Rating Film Highest to Lowest
  - Rating Film Lowest to Highest
  - Film Terbaru
  - Film Tertua
  - Film Berdasarkan Urutan Alfabet (A-Z)
- 🎬 Halaman detail film
- 📤 Share film
- ▶️ Tombol Watch Now
- 🖼️ Popular movie horizontal slider
- 🚫 Empty state ketika film tidak ditemukan

---

### 📷 Tampilan Aplikasi

---

### 🚀 Splash Screen

<img width="630" height="1236" alt="Screenshot 2026-05-13 020744" src="https://github.com/user-attachments/assets/1c7bf674-46b2-4a94-a493-124b1f9b2b4f" />

#### 📌 Penjelasan
Splash Screen merupakan tampilan pertama saat aplikasi dijalankan.  
Halaman ini digunakan untuk memberikan identitas aplikasi sebelum pengguna masuk ke halaman utama.

#### ✨ Fitur pada Splash Screen
- Menampilkan logo dan nama aplikasi **MovieVerse**
- Menggunakan tampilan dark theme modern
- Memberikan kesan profesional saat aplikasi dibuka
- Transisi otomatis menuju Home Screen

---

### 🏠 Home Screen

<img width="631" height="1353" alt="Screenshot 2026-05-13 020801" src="https://github.com/user-attachments/assets/c9966c15-9e34-42cd-ad93-53bd47300f92" />

#### 📌 Penjelasan
Home Screen merupakan halaman utama aplikasi yang digunakan pengguna untuk menjelajahi daftar film.

Pada halaman ini pengguna dapat mencari, memfilter, melakukan sorting, dan melihat daftar movie populer maupun seluruh movie yang tersedia.

#### ✨ Fitur pada Home Screen
- 🔍 **Search Movie**  
  Digunakan untuk mencari film berdasarkan judul.

- 🎭 **Filter Genre**  
  Menampilkan film berdasarkan kategori genre tertentu.

- 📅 **Filter Year**  
  Menampilkan film berdasarkan tahun rilis.

- ⭐ **Filter Rating**  
  Menampilkan film berdasarkan minimal rating tertentu.

- 📊 **Sorting Movie**  
  Mengurutkan film berdasarkan:
  - Rating tertinggi ke terendah
  - Rating terendah ke tertinggi
  - Tahun terbaru
  - Tahun terlama
  - Judul A-Z

- 🖼️ **Popular Movies Section**  
  Menampilkan daftar movie populer dalam bentuk horizontal slider.

- 🎬 **Movie List**  
  Menampilkan seluruh daftar movie dalam bentuk vertical list.

- 🚫 **Empty State**  
  Menampilkan pesan ketika hasil pencarian atau filter tidak ditemukan.

---

### 🎬 Detail Screen

<img width="584" height="1346" alt="Screenshot 2026-05-13 031534" src="https://github.com/user-attachments/assets/4588c2f7-72c1-4af2-9236-f31c73fa15a1" />

#### 📌 Penjelasan
Detail Screen digunakan untuk menampilkan informasi lengkap mengenai movie yang dipilih pengguna dari Home Screen.

Halaman ini memberikan pengalaman seperti platform streaming modern dengan tampilan poster besar dan informasi detail movie.

#### ✨ Fitur pada Detail Screen
- 🖼️ **Movie Poster**  
  Menampilkan poster movie berukuran besar.

- 📝 **Movie Information**  
  Menampilkan:
  - Judul movie
  - Genre
  - Rating
  - Tahun rilis
  - Durasi movie

- ▶️ **Watch Now Button**  
  Tombol aksi utama untuk menonton movie.

- ❤️ **Favorite Button**  
  Menambahkan atau menghapus movie dari daftar favorit.

- 📤 **Share Button**  
  Membagikan informasi movie ke aplikasi lain.

- 📖 **Overview Section**  
  Menampilkan deskripsi atau sinopsis movie.

- 🎭 **Cast Section**  
  Menampilkan daftar pemeran movie sesuai data movie.

- 🎬 **Director Section**  
  Menampilkan sutradara movie sesuai data movie.

---

### 📂 Struktur Project
```bash
app/
├── manifests/
│ └── AndroidManifest.xml
│     → Konfigurasi utama aplikasi (activity, permission, dll)
│
├── kotlin+java/
│ ├── com.example.movieverse/
│    ├── adapter/
│    │ ├── MovieAdapter.kt
│    │ │   → Adapter RecyclerView untuk daftar semua movie
│    │ └── PopularMovieAdapter.kt
│    │     → Adapter RecyclerView horizontal untuk popular movie
│    │
│    ├── data/
│    │ └── MovieData.kt
│    │     → Menyimpan dummy data movie, cast, director, dan popular movie
│    │
│    ├── model/
│    │ └── Movie.kt
│    │     → Data class model movie
│    │
│    ├── ui.theme/
│    │ ├── Color.kt
│    │ │   → Berisi definisi warna yang digunakan pada aplikasi
│    │ ├── Theme.kt
│    │ │   → Mengatur tema utama aplikasi MovieVerse
│    │ └── Type.kt
│    │     → Mengatur typography dan style font aplikasi
│    │
│    └── activity/
│        ├── DetailActivity.kt
│        │   → Halaman detail movie
│        │
│        ├── MainActivity.kt
│        │   → Halaman utama movie
│        │
│        └── SplashActivity.kt
│            → Halaman pembuka (splash screen) saat aplikasi dijalankan
│
│ ├── com.example.movieverse (androidTest)
│    └── ExampleInstrumentedTest
│        → Berisi instrumented testing yang dijalankan langsung pada emulator atau device Android
│
│ └── com.example.movieverse (test)
│    └── ExampleUnitTest
│        → Berisi unit testing untuk menguji logika aplikasi tanpa menjalankan emulator/device
│
├── res/
│ ├── drawable/
│ │ ├── interstellar.jpg
│ │ ├── inception.jpg
│ │ ├── avatar.jpg
│ │ ├── batman.jpg
│ │ ├── joker.jpg
│ │ ├── endgame.jpg
│ │ ├── doctor_strange.jpg
│ │ ├── ic_favorite.xml
│ │ ├── ic_favorite_border.xml
│ │ ├── bg_circle_button.xml
│ │ ├── ic_launcher_background.xml
│ │ ├── ic_launcher_foreground.xml
│ │ ├── ic_movieverse_logo.png
│ │ └── spiderman.jpg
│ │     → Asset poster movie
│ │
│ ├── layout/
│ │ ├── activity_main.xml
│ │ │   → Layout halaman utama
│ │ ├── activity_detail.xml
│ │ │   → Layout halaman detail movie
│ │ ├── activity_splash.xml
│ │ │   → Layout halaman pembuka (splash screen) saat aplikasi dijalankan
│ │ ├── item_movie.xml
│ │ │   → Layout item movie vertical
│ │ └── item_popular_movie.xml
│ │     → Layout item popular movie horizontal
│ │
│ ├── mipmap/
│ │ ├── ic_launcher/
│ │ │ ├── ic_launcher.webp (hdpi)
│ │ │     → Icon launcher aplikasi untuk resolusi layar hdpi
│ │ │ ├── ic_launcher.webp (mdpi)
│ │ │     → Icon launcher aplikasi untuk resolusi layar mdpi
│ │ │ ├── ic_launcher.webp (xhdpi)
│ │ │     → Icon launcher aplikasi untuk resolusi layar xhdpi
│ │ │ ├── ic_launcher.webp (xxhdpi)
│ │ │     → Icon launcher aplikasi untuk resolusi layar xxhdpi
│ │ │ ├── ic_launcher.webp (xxxhdpi)
│ │ │     → Icon launcher aplikasi untuk resolusi layar xxxhdpi
│ │ │ └── ic_launcher.xml (anydpi-v26)
│ │       → Konfigurasi adaptive launcher icon untuk Android 8.0+
│ │
│ │ ├── ic_launcher_foreground/
│ │ │ ├── ic_launcher_foreground.webp (hdpi)
│ │ │     → Foreground icon launcher untuk resolusi hdpi
│ │ │ ├── ic_launcher_foreground.webp (mdpi)
│ │ │     → Foreground icon launcher untuk resolusi mdpi
│ │ │ ├── ic_launcher_foreground.webp (xhdpi)
│ │ │     → Foreground icon launcher untuk resolusi xhdpi
│ │ │ ├── ic_launcher_foreground.webp (xxhdpi)
│ │ │     → Foreground icon launcher untuk resolusi xxhdpi
│ │ │ └── ic_launcher_foreground.webp (xxxhdpi)
│ │       → Foreground icon launcher untuk resolusi xxxhdpi
│ │
│ │ └── ic_launcher_round/
│ │ │ ├── ic_launcher_round.webp (hdpi)
│ │ │     → Icon launcher bulat untuk resolusi hdpi
│ │ │ ├── ic_launcher_round.webp (mdpi)
│ │ │     → Icon launcher bulat untuk resolusi mdpi
│ │ │ ├── ic_launcher_round.webp (xhdpi)
│ │ │     → Icon launcher bulat untuk resolusi xhdpi
│ │ │ ├── ic_launcher_round.webp (xxhdpi)
│ │ │     → Icon launcher bulat untuk resolusi xxhdpi
│ │ │ ├── ic_launcher_round.webp (xxxhdpi)
│ │ │     → Icon launcher bulat untuk resolusi xxxhdpi
│ │ │ └── ic_launcher_round.xml (anydpi-v26)
│ │       → Konfigurasi adaptive round launcher icon untuk Android 8.0+
│ │
│ ├── values/
│ │ ├── colors.xml
│ │ │   → Definisi warna aplikasi
│ │ ├── strings.xml
│ │ │   → String resource aplikasi
│ │ ├── ic_launcher_background.xml
│ │ │   → Background vector untuk icon launcher aplikasi
│ │ └── themes.xml
│ │     → Tema aplikasi
│ │
│ └── xml/
│ │ ├── backup_rules.xml
│ │ │   → Mengatur aturan backup data aplikasi
│ │ └── data_extraction_rules.xml
│ │     → Mengatur aturan ekstraksi data saat proses backup dan restore
│ │
│
├── Gradle Scripts/
│ ├── build.gradle.kts (Project: TugasUTSPemrogramanMobile)
│ ├── build.gradle.kts (Module: app)
│ ├── proguard-rules.pro (ProGuard Rules for ":app")
│ ├── gradle.properties (Project Properties)
│ ├── gradle-wrapper.properties (Greadle Version)
│ ├── libs.versions.toml (Version Catalog "libs")
│ ├── local.properties (SDK Location)
│ └── settings.gradle.kts (Project Settings)
│
└── README.md
```

---

### ▶️ Cara Menjalankan Project
1. Clone repository ini:
   ```bash
   git clone https://github.com/BagusNaren/Tugas-2-Pemrograman-Mobile
   ```
2. Buka project di Android Studio
3. Tunggu proses Gradle Sync dan Gradle Build selesai
4. Jalankan emulator / hubungkan device
5. Klik tombol:
   ```bash
   Run 'app' ▶️
   ```

---

### 🧠 Konsep yang Dipelajari
- RecyclerView & Adapter
- Intent dan Activity Navigation
- Passing Data antar Activity
- Filtering & Sorting Data
- SearchView
- Custom UI Android XML
- Event Listener
- State Management sederhana
- NestedScrollView + RecyclerView

---

### ✨ Preview Aplikasi
MovieVerse menghadirkan tampilan modern bergaya streaming platform dengan nuansa dark mode dan pengalaman browsing movie yang interaktif.

---

# Terima kasih telah membaca dokumentasi MovieVerse! 🎉
