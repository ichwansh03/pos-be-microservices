## Notes for RabbitMQ
* Exchange sebagai penerima pesan pertama dari producer
* Durability, apakah exchange tetap ada setelah RabbitMQ di restart, Durable (tetap ada setelah di restart), Transient (hilang setelah di restart)
* Queue sebagai penyimpanan pesan dari exchange dan akan diambil oleh consumer
* Binding sebagai penghubung antara exchange dan queue
* Automatic ack, pesan akan dihapus dari queue setelah diterima oleh consumer ketika Get Message di queue
* direct exchange, routing key harus sama dengan binding key
* fanout exchange, routing key tidak digunakan, semua pesan akan dikirim ke semua queue yang terikat pada exchange
* topic exchange, routing key harus sesuai dengan pola binding key, misalnya `order.created` akan cocok dengan binding key `order.*` atau `*.created` atau dengan pola `order.#` yang akan cocok dengan semua routing key yang dimulai dengan `order.`
* header exchange, routing key tidak digunakan, pesan akan dikirim ke queue yang memiliki header yang sesuai dengan header pada pesan
* Policy, aturan yang diterapkan pada queue atau exchange, misalnya untuk mengatur TTL (Time To Live) pesan, maksimal ukuran pesan, dan lain-lain
* [RabbitMQ Client liblary](https://www.rabbitmq.com/client-libraries/devtools)
* [RabbitMQ Binder Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream-binder-rabbit.html#_rabbitmq_binder_overview)