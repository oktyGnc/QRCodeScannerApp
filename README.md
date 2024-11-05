# <p align="center"> QR CODE SCANNER APP </p>  

## 🎬 Video
https://drive.google.com/file/d/1dxbtvv0Vx5DPQbb1wNeZyr6zCFXwtu8a/view?usp=drive_link
<br>

## Uygulama Özellikleri

- **QR Kod Tarama**: Kullanıcılar, QR kodları hızlı ve kolay bir şekilde tarayabilir.

- **Kamera Desteği**: Uygulama, cihazın arka kamerasını kullanarak gerçek zamanlı görüntü akışı sağlar.

- **Flaş Işığı Kontrolü**: Kullanıcılar, düşük ışık koşullarında tarama yapabilmek için flaş ışığını açıp kapatabilir.

- **URL Açma**: Taranan QR kodu bir URL içeriyorsa, kullanıcılar bu URL'yi varsayılan tarayıcıda açabilir.

- **Kullanıcı Dostu Arayüz**: Basit ve sezgisel bir arayüz ile kullanıcıların kolayca QR kod tarama işlemini gerçekleştirmesine olanak tanır.

- **Hızlı Tarama**: QR kodları hızlı bir şekilde taramak için optimize edilmiştir.

## :point_down: Kullanılan Teklonojiler
1. AndroidX Camera
   androidx.camera:camera-camera2:1.3.0: Android'in kamera API'sini kullanarak kamera işlevselliği sağlamak için kullanılır.
   androidx.camera:camera-lifecycle:1.3.0: Kamera yaşam döngüsünü yönetmek için kullanılır.
   androidx.camera:camera-view:1.3.0: Kamera görüntüsünü kullanıcı arayüzünde göstermek için kullanılan bir bileşen.
2. Google ML Kit
   com.google.mlkit:barcode-scanning:17.2.0: Barkod ve QR kod tarama işlevselliği sağlamak için kullanılır. Bu kütüphane, görüntü analizi ve barkod tanıma işlemlerini gerçekleştirmek için kullanılır.
3. Android View Binding
   View Binding: XML dosyalarındaki bileşenlere daha güvenli ve kolay erişim sağlamak için kullanılır. build.gradle dosyasında viewBinding true olarak ayarlanmıştır.
4. Android Permissions
   Kamera İzni: Uygulama, kamera erişimi için izin talep eder. AndroidManifest.xml dosyasında android.permission.CAMERA izni belirtilmiştir.
5. ConstraintLayout
   androidx.constraintlayout.widget.ConstraintLayout: Kullanıcı arayüzü bileşenlerini düzenlemek için kullanılan bir layout türüdür. Hem activity_main.xml hem de activity_scanner.xml dosyalarında kullanılmıştır.
6. Kotlin
   Uygulama, Android uygulama geliştirmek için Kotlin programlama dili ile yazılmıştır.
7. ExecutorService
   Çoklu iş parçacığı yönetimi: QR kod analizi için arka planda çalışan iş parçacıkları oluşturmak için kullanılır.
8. Custom View
   ScannerOverlay: QR kod tarayıcı ekranında özel bir overlay görüntülemek için kullanılan özel bir View sınıfı.
9. Intent ve Activity
   Uygulama, farklı ekranlar arasında geçiş yapmak için Intent nesnelerini kullanır ve MainActivity ile ScannerActivity arasında geçiş yapar.
10. Toast Mesajları
    Kullanıcıya bilgi vermek için Toast mesajları kullanılır.

## :pencil2: Dependency

app build.gradle
```
plugins {
alias(libs.plugins.android.application)
alias(libs.plugins.kotlin.android)
}
```
```
buildFeatures{
        viewBinding = true
    }
    
    dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.androidx.camera.camera2)
    implementation (libs.androidx.camera.lifecycle)
    implementation (libs.androidx.camera.view)
    implementation (libs.barcode.scanning)
}
```
project build.gradle

```
plugins {
alias(libs.plugins.android.application) apply false
alias(libs.plugins.kotlin.android) apply false
}
```

## :pencil2: Kurulum Talimatları

Projeyi bilgisayarınıza klonlamak için aşağıdaki komutu kullanın:

```bash
git clone https://github.com/oktayGnc/
```