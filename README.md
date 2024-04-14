# Kartaca Staj Projesi

## Hazırlayan: Atika Zeynep Evmez

Bu program Kartaca Çekirdekten Yetişenler Programı başvurusu için hazırlanmıştır.

Program basit bir panel içerisinde, dünya haritası üzerinde anormal depremleri gösterebilecek bir web uygulamasıdır.

## Önkoşullar

Proogramı çalıştırmak için aşağıdaki önkoşulları sağlamalısınız:
- Docker yüklemiş olmanız gerekiyor. [Docker'ı Yükle](https://docs.docker.com/get-docker/)
- Docker-compose yüklemiş olmanız gerekiyor. [Docker Compose'yi Yükle](https://docs.docker.com/compose/install/)

## Başlarken

1. Depoyu klonlayın:

    ```bash
    git clone git@github.com:atikazeynep/kartaca_internship_case.git
    ```

2. Proje dizinine gidin:

    ```bash
    cd kartaca_internship_case
    ```

3. Projeyi Docker Compose kullanarak ayağa kaldırın:

    ```bash
    docker-compose up --build
    ```

    Bu komut, backend ve frontend için Docker imajlarını oluşturacak, her bir servis için bir konteyner oluşturacak ve bunları başlatacaktır.

4. Konteynerler başlatıldıktan sonra uygulamaya erişebilirsiniz:

    - Backend: Web tarayıcınızı açın ve `http://localhost:8080` adresine gidin.
    - Frontend: Web tarayıcınızı açın ve `http://localhost:3000` veya `http://localhost:4000` adreslerinden birine gidin, frontend uygulamanızın çalıştığı porta bağlı olarak.

5. Konteynerleri durdurmak için terminalde Docker Compose çalıştırırken `Ctrl + C` tuşlarına basabilir veya aşağıdaki komutu kullanabilirsiniz:

    ```bash
    docker-compose down
    ```

## Ek Notlar

- Kodlarda değişiklik yaparsanız, aynı `docker-compose up --build` komutunu kullanarak konteynerleri yeniden oluşturabilir ve başlatabilirsiniz.
- Docker Compose'u arka planda çalıştırmak için `-d` bayrağını ekleyerek kullanabilirsiniz: `docker-compose up -d`.
