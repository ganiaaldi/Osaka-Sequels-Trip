package com.aldi.osakasequelstrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldi.osakasequelstrip.Adapter.WisataAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvWisata.apply {
            layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
            adapter = WisataAdapter(wisataData)

            (adapter as WisataAdapter).setOnItemClickCallback(object : WisataAdapter.OnItemClickCallback {
                override fun onItemClicked(data: WisataModel) {
                 //function to detail page
                }
            })
        }
    }

    private val wisataData = arrayListOf(
        WisataModel("Distrik Osaka san-go", "Tiga distrik yang terhubung ini terkenal sebagai surga belanja, " +
                "jalan-jalan, dan kuliner. Menyatu bersama alam di Namba Parks. Belanja di butik lokal dan pusat perbelanjaan terbesar di Shinsaibashi. " +
                "Berfoto dihiasi lampu neon sambil menikmati jajanan kaki lima di Dotonbori.", R.drawable.dotonbori),
        WisataModel("Istana Osaka", "Istana Osaka (大阪城 Ōsaka-jō) adalah istana yang terletak di dalam Taman Istana Osaka, distrik Chuo-ku, kota Osaka, Jepang. Istana Osaka berada di ujung paling sebelah utara daerah Uemachi, menempati lokasi tanah yang paling tinggi dibandingkan dengan wilayah sekelilingnya.\n" +
                "\n" +
                "Istana Osaka merupakan bangunan peninggalan budaya yang dilindungi oleh pemerintah Jepang. Menara utama Istana Osaka yang menjulang tinggi merupakan simbol kota Osaka.\n" +
                "\n" +
                "Istana Osaka dimanfaatkan sebagai istana sekaligus benteng sejak zaman Azuchi Momoyama hingga zaman Edo. Istana Osaka yang ada sekarang terdiri dari menara utama yang dilindungi oleh dua lapis tembok tinggi yang dikelilingi oleh dua lapis parit, parit bagian dalam (Uchibori) dan parit bagian luar (Sotobori). Air yang digunakan untuk mengaliri parit istana diambil dari Sungai Yodo mengalir di sebelah utara Istana Osaka.\n" +
                "\n" +
                "Menurut orang Jepang zaman dulu, Istana Osaka (大坂城; Ōsaka-jō atau Ōzaka-jō) berada di provinsi Setsu (nama zaman dulu untuk Osaka dan sekelilingnya), wilayah Higashinari Goori, Osaka. Sesuai dengan penggantian karakter Kanji yang digunakan untuk menulis kota Osaka dalam bahasa Jepang, nama Istana Osaka sekarang ditulis sebagai 大阪城 (Ōsaka-jō).", R.drawable.osakacastle),
        WisataModel("Osaka Aquarium Kaiyukan", "Akuarium Osaka Kaiyukan (海遊館 Kaiyūkan) adalah akuarium yang terletak di distrik Minato di Osaka, Jepang, dekat Teluk Osaka. Akuarium ini merupakan salah satu akuarium publik terbesar di dunia, dan merupakan anggota dari Asosiasi Kebun Binatang dan Akuarium Jepang (JAZA).\n" +
                "\n" +
                "Akuarium ini berjarak sekitar lima menit dengan berjalan kaki dari Stasiun Osakako di Kereta Bawah Tanah Osaka Metro Jalur Chūō, dan berada di sebelah kincir ria Tempozan.\n" +
                "\n",R.drawable.kaiyukanaquarium),
        WisataModel("Kuil Shitennoji", "Shitennō-ji (Jepang: 四天王寺; juga Arahaka-ji, Nanba-ji, atau Mitsu-ji) adalah sebuah kuil Buddhis di Ōsaka, Jepang. Kuil ini terkadang dianggap sebagai kuil Buddhis pertama dan tertua yang dikelola secara resmi di Jepang,meskipun bangunan kuil telah dibangun kembali selama berabad-abad.\n" +
                "Shitennō diyakini merupakan empat maharaja surgawi. Kuil ini, yang dibangun oleh Pangeran Shōtoku untuk menghormati mereka, memiliki empat lembaga, masing-masing untuk membantu Jepang mencapai tingkat peradaban yang lebih tinggi. Shika-in (四箇院 Empat Lembaga) ini berpusat pada tujuh bangunan garan (伽藍) (kompleks yang berada di dalam tembok), dan meliputi sebuah Kyōden-in (Lembaga Agama dan Pendidikan), sebuah Hiden-in (Lembaga Kesejahteraan), sebuah Ryōbyō-in (rumah sakit), dan sebuah Seiyaku-in (apotek) untuk memberikan perawatan penting kepada rakyat Jepang.\n" +
                "Garan terdiri dari sebuah pagoda lima lantai, sebuah Paviliun Emas utama (Kondō) yang memajang sebuah citra Bodhisattva Kannon, dan Kōdō (Balairung Ceramah) di bawah sebuah koridor tertutup yang memiliki tiga gerbang (Gerbang Dewa,Gerbang Barat, dan Gerbang Timur). Yang mengelilingi kompleks pusat ini adalah Gerbang Selatan Besar (Nandaimon), dan sebuah Gerbang Timur Besar (Higashi-no-ō'mon). Di sebelah barat terdapat Gerbang Barat Besar (Nishi-no-ō'mon), juga dikenal sebagai Gokuraku-mon (極楽門). Lebih jauh ke barat terdapat sebuah batu torii, yang secara luas diterima sebagai Gerbang Timur menuju gokuraku-jōdo (極楽浄土 Surga Barat, atau Tanah Murni).\n" +
                "\n" +
                "Shitennō-ji menjual beberapa suvenir yang merupakan produk mereka pada tanggal 21 setiap bulan",R.drawable.shintennonji),
        WisataModel("Menara Tsutenkaku", "Tsūtenkaku (通天閣) adalah menara di pusat perbelanjaan Shinsekai, Naniwa-ku, Osaka. Menara ini tingginya 100 m (103 m berikut penangkal petir). Berlokasi di sebuah lahan sempit, lebar antara kaki-kaki menara hanya 24 m. Menara ini hanya berfungsi sebagai menara observasi. Dek observasi lantai 4 berada di ketinggian 84 m, dek observasi lantai 5 berada di ketinggian 91 m. Menara yang ada sekarang ini adalah menara Tsūtenkaku generasi kedua. Menara generasi pertama dibongkar setelah peristiwa kebakaran tahun 1943.\n" +
                "\n" +
                "Pemilik menara ini adalah Tsutenkaku Kanko Co. Ltd. Menara ini telah menjadi salah satu markah tanah kota Osaka, dan dimasukkan ke dalam daftar Aset Budaya Nyata Jepang pada 15 Mei 2007. Selain sebagai tujuan wisata, menara ini dipakai untuk papan iklan oleh Hitachi.",R.drawable.tsutenkaku),
        WisataModel("Gunung Koya", "Gunung Kōya (高野山 Kōya-san) adalah sebutan untuk gunung-gunung yang tingginya sekitar 1.000 m di Prefektur Wakayama, Jepang. Sebutan Kōya-san juga merupakan sebutan lain untuk kuil Buddha bernama Kongōbuji yang terletak di gunung ini. Meskipun demikian, tidak ada gunung di Jepang yang secara resmi bernama Gunung Kōya.\n" +
                "\n" +
                "Pembangunan kuil di Gunung Kōya pertama kali dirintis oleh Kūkai pada tahun 819. Gunung Kōya terutama dikenal sebagai markas internasional Buddhisme Jepang sekte Koyasan Shingon. Meskipun di sekelilingnya terdapat 8 puncak-puncak gunung, tempat yang dijadikan lokasi kuil Gunung Kōya adalah lembah yang berketinggian 800 m. Kompleks kuil berkembang menjadi Kota Koya yang dijadikan lokasi bagi sebuah universitas kajian agama. Selain itu, di Gunung Kōya terdapat lebih dari 120 kuil yang sebagian di antaranya menyediakan penginapan bagi para peziarah.\n" +
                "\n" +
                "Di Gunung Kōya terdapat berbagai situs bersejarah, di antaranya:\n" +
                "\n" +
                "Okunoin (奥の院), makam Kūkai yang dikelilingi kompleks pekuburan yang luas\n" +
                "Danjogaran (壇上伽藍), bangunan utama Gunung Kōya\n" +
                "Konpon Daitō (根本大塔), pagoda yang menurut kepercayaan doktrin Shingon melambangkan titik pusat mandala yang tidak hanya meliputi Gunung Kōya, melainkan juga seluruh Jepang\n" +
                "Kongōbu-ji (金剛峯寺), kuil utama Buddhisme Koyasan Shingon\n" +
                "Pada tahun 2004, UNESCO menetapkan Gunung Kōya bersama-sama dengan dua lokasi lainnya di Semenanjung Kii sebagai Situs Warisan Dunia.",R.drawable.koya),
        WisataModel("Umeda Sky Building", "Umeda (梅田) adalah distrik bisnis, komersial, perbelanjaan dan hiburan utama di Distrik Kita, Osaka, Jepang. Nama harfiah distrik ini berarti \"ladang bunga prem\". \n" +
                "Pembangunan Umeda Sky Building pada tahun 1993 dan renovasi Kota Stasiun Osaka pada tahun 2011 telah mengubah Distrik Umeda dari kawasan bisnis menjadi tempat pariwisata dan pusat perbelanjaan.",R.drawable.umeda),
        WisataModel("Museum of Housing & Living", "Dari museum ini kemungkinan orang orang yang datang bisa memahami bagaimana kehidupan orang Jepang jaman dahulu, secara di buat semirip dan sedetail baik dari rumah, alat masak, furniture dan lainnya. disini juga dapat menyewa pakaian khas jepang yaitu kimono atau yukata jadi akan berasa lebih hidup suasananya.",R.drawable.museum),
        WisataModel("Area Perbelanjaan Tenjinbashisuji", "Tempat perbelanjaan Tenjibashi - Suji terletak di Kita-bangsal, Kota Osaka merupakan beratap jalan perbelanjaan terpanjang di Jepang. Jalan perbelanjaan dibagi menjadi enam wilayah, memiliki restoran Osaka-seperti, toko-toko tua yang khusus , toko pakaian dan toko-toko komersial lainnya. Hanya berjalan-jalan di jalan adalah pengalaman yang menyenangkan.\n" +
                "\n" +
                "Jam buka bervariasi tergantung pada toko-toko. Sebagai jalan belanja memadati dengan orang-orang pada akhir pekan dan hari libur, dianjurkan untuk berkunjung ke sana pada hari kerja. Orang-orang di Osaka cenderung berjalan pada kecepatan yang lebih cepat, jadi harap berhati-hati untuk tidak berdesak-desakan di kerumunan di jalan yang sibuk.",R.drawable.tenjinbanshi),
        WisataModel("Tennen Onsen Naniwa-no-yu", "Berendam",R.drawable.onsen)
    )



}
