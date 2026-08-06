# Secret ID Mod

Minecraft sunucuları için gelişmiş rol, ekonomi, vergi, devlet yönetimi, yasa ve tüzel kişilik sistemleri sunan bir Fabric modudur.

## Sürüm
Güncel sürüm: **1.7.1**

## Özellikler

### 1. Rol Sistemi
Oyunculara çeşitli hükümet rolleri atanabilir. Bu roller sayesinde devlet hazinesine, kurumlara ve vergilere müdahale edebilirler.
- **Roller:** `PRESIDENT` (Cumhurbaşkanı), `PRIME_MINISTER` (Başbakan), `MINISTER` (Bakan), `MAYOR` (Belediye Başkanı), `MP` (Milletvekili), `NONE` (Vatandaş).
- `/setrole <secret_id> <rol>`: Bir oyuncunun rolünü ayarlar (Sadece sunucu yetkilileri kullanabilir).

### 2. Gizli Kimlik (Secret ID) ve Ekonomi
Her oyuncunun 6 haneli rastgele bir gizli kimliği (Örn: A4B9Z1) ve bir bakiye hesabı bulunur.
- `/id`: Kendi gizli kimliğinizi (Secret ID) gösterir.
- `/bakiye`: Mevcut bakiyenizi (AK Lirası) gösterir.
- `/bakiye ekle <secret_id> <miktar>`: OP/Yönetici komutu. İstenen ID'ye para ekler.
- `/bakiye sil <secret_id> <miktar>`: OP/Yönetici komutu. İstenen ID'den para siler.
- `/gonder <hedef_secret_id> <miktar>`: Kendi hesabınızdan başka bir ID'ye para gönderir.
- `/oyuncupara <secret_id>`: Hedef oyuncunun bakiyesini, tapularını, kurumlarını ve dükkanlarını gösterir (Cumhurbaşkanı, Başbakan veya Yetkili).

### 3. Vergi Sistemi
Hükümet yetkilileri vergi oluşturabilir. Oyuncular bu vergileri devlet hazinesine ödemek zorundadır.
- `/vergi ekle <vergi_adi> <miktar>`: Yeni bir vergi kalemi ve tutarı oluşturur (Cumhurbaşkanı ve Başbakan).
- `/vergi borcum`: Oyuncunun devlete olan borçlarını listeler.
- `/vergi ode <vergi_adi> <miktar>`: Vergi borcunu öder (Para doğrudan devlet hazinesine geçer).

### 4. Devlet Hazinesi
Devletin kendine ait bir kasası vardır. Vergi gelirleri buraya birikir.
- `/hazine`: Hazinedeki toplam bakiyeyi gösterir (Sadece Hükümet).
- `/hazine gonder <hedef_secret_id> <miktar>`: Hazineden bir oyuncuya ödeme/maaş gönderir (Cumhurbaşkanı ve Başbakan).
- `/hazine sifirla`: Devlet hazinesini tamamen sıfırlar (Cumhurbaşkanı, Başbakan veya Yetkili).
- `/hazine fonla <binlik_miktar>`: Yoktan para basmak yerine envanterdeki altın karşılığı hazineye para ekler. 1000 AK Lirası = 64 Altın Külçesi (Sadece Cumhurbaşkanı).
- `/govdata`: Tüm Hükümet istatistiklerini (Roller, Bakiyeler, Borçlar) sunar (Sadece Hükümet).

### 5. Yasa ve Oylama Sistemi
Yasa tasarıları mecliste (Milletvekilleri ve Başbakan) oylanır ve Cumhurbaşkanı tarafından onaylanıp yürürlüğe girer. Tüm yasalar `secret_id_laws.json` dosyasında tutulur.
- `/yasa olustur <secret_id> <baslik> <icerik...>`: Yeni yasa tasarısı açar.
- `/yasa duzenle <secret_id> <yasa_kodu> <yeni_icerik...>`: Yasa içeriğini değiştirir. (Sadece Başbakan)
- `/yasa oyla <secret_id> <yasa_kodu> <evet/hayir>`: Belirtilen yasaya evet veya hayır oyu atar. (Milletvekili ve Başbakan)
- `/yasa onayla <secret_id> <yasa_kodu>`: Oylamada olan bir yasayı yürürlüğe koyar. (Cumhurbaşkanı)
- `/yasa reddet <secret_id> <yasa_kodu>`: Yasa tasarısını reddeder. (Cumhurbaşkanı)
- `/yasa liste`: Tüm yasaları ve durumlarını listeler.
- `/yasa detay <yasa_kodu>`: Bir yasanın metnini ve tam evet/hayır oylarını gösterir.

### 6. Sandık Dükkanı (Shop Chest)
Oyuncular vanilya sandık veya varillerini kişisel dükkanlara çevirebilir.
- `/shop create <fiyat>`: Bakılan sandığı/varili dükkana dönüştürür.
- `/shop price <yeni_fiyat>`: Bakılan dükkanın fiyatını günceller.
- `/shop remove`: Dükkanı kaldırır.
- *Kullanım:* Sandığa ilk sağ tıklandığında bilgi verir, 5 saniye içinde tekrar sağ tıklandığında içindeki eşya satın alınır. Sadece dükkan sahibi veya OP'ler sandığı açıp kırabilir.

### 7. Tüzel Kişilik (Kurum/Şirket) Sistemi
Devlet veya oyuncular tarafından yönetilen, kendi bakiyesi olan bağımsız hesaplar. Taksi modu gibi başka modlar da bu sistemi fon havuzu olarak kullanabilir.
- `/kurum olustur kamu <kurum_adi>`: Yeni bir kamu kurumu oluşturur. ID `XKUR01`, `XKUR02` şeklinde oluşturulur. (Sadece Cumhurbaşkanı, Başbakan veya Milletvekili kullanabilir).
- `/kurum olustur ozel <kurum_adi>`: Yeni bir özel kurum oluşturur. ID `X00001`, `X00002` şeklinde oluşturulur. (Sadece Cumhurbaşkanı, Başbakan veya Milletvekili kullanabilir).
- `/kurum bilgi <X_kodu>`: Kurum bilgisini ve bakiyesini gösterir.
- `/kurum fonla <secret_id> <X_kodu> <miktar>`: Devlet hazinesinden kuruma bakiye aktarır (Sadece Cumhurbaşkanı yetkilidir ve sahteciliği önlemek için kendi `secret_id`'si ile imzalamalıdır).
- `/kurum yatir <X_kodu> <miktar>`: Kendi cebinizden kurumun kasasına para yatırır.
- `/kurum cek <X_kodu> <miktar>`: Kurum kasasından kendi cebinize para çeker (Sadece Sahibi).
- `/kurum gonder <X_kodu> <hedef_secret_id> <miktar>`: Kurum kasasından bir oyuncuya para öder (Sadece Sahibi).

**Geliştiriciler İçin API Komutu:**
- `/kurum_api ode <X_kodu> <oyuncu_adi> <miktar>`: Harici modların (veya konsol/OP'lerin) görev tamamlandığında bir kurumun kasasından o oyuncuya para yatırmasına imkan tanır.

### 8. Tapu Sistemi
Oyuncuların üzerine kaydedilebilen, değer biçilmiş mülk sistemidir.
- `/tapularim`: Oyuncunun sahip olduğu tüm tapuları, kurumları ve dükkanları id ve değerleriyle birlikte listeler (Tüm oyuncular kullanabilir).
- `/tapu kayit <sahip_secret_id> <deger>`: Yeni bir tapu oluşturarak belirtilen oyuncuya kaydeder (Cumhurbaşkanı, Başbakan veya Yetkili).
