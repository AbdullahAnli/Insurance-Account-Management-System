# Insurance-Account-Management-System-Application

### 📖 Tanım

<ul>
  <li><b>Insurance-Account-Management-System-Application</b> bir <b>Spring Boot uygulamasıdır.</b> Sigorta şirketinin finansal işlemlerini yönetmek için bir sistem. Bu sistem, prim tahsilatlarını takip edebilir, müşteri ödemelerini işleyebilir ve finansal raporlar oluşturabilir.</li> 
  <li>
    <b>Açıklama:</b>
   <ul>
      <li><b>CustomerController:</b> Müşteri işlemlerini yönetmek için kullanılan controller. Müşteri bilgilerini oluşturma, silme ve güncelleme işlemleri için dışarıya açılan API sağlar.</li>
      <li><b>PaymentController:</b> Ödeme işlemlerini yönetmek için kullanılan controller. Müşteri ödemelerini oluşturma, silme ve güncelleme işlemleri için dışarıya açılan API sağlar.</li>
      <li><b>PolicyController:</b> Poliçe işlemlerini yönetmek için kullanılan controller. Poliçe bilgilerini oluşturma, silme ve güncelleme işlemleri için dışarıya açılan API sağlar.</li>
      <li><b>FinancialController:</b> Finansal raporları oluşturmak, silmek ve güncellemek için kullanılan controller. Dışarıya açılan API aracılığıyla finansal verilerin yönetimini sağlar.</li>
   </ul>
  </li>
</ul>

### Uygulamadaki REST API'ler [BASE URL = /api/customer]

<table style="width:100%">
  <tr>
      <th>Metot</th>
      <th>Url</th>
      <th>Açıklama</th>
      <th>Response</th>
      <th>Request Body</th>
      <th>Request Param</th>
      <th>Path Variable</th>
      <th>HttpStatus</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>/all</td> 
      <td>Oluşturulmuş Tüm Müşterileri Getirir</td>
      <td>List<<Customer>Customer> getAllCustomer</td>
      <td> </td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/{id}</td>
      <td>id ye göre müşteriyi getirir.</td>
      <td> ResponseEntity<<Customer>Customer>
            getByCustomerId </td>
      <td> </td>
      <td></td>
      <td>Long id</td>
      <td>200</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/create</td>
    <td>Müşteriyi oluşturur.</td>
    <td>Customer customer</td>
    <td>Customer customer</td>
    <td></td>
    <td></td>
    <td>201</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/{id}</td>
    <td>İlgili Müşterilerin bilgilerini günceller.</td>
    <td>Customer customer</td>
    <td>Customer updateCustomer</td>
    <td></td>
    <td>Long id</td>
    <td>201</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/{id}</td>
    <td>İlgili müşteriyi siler.</td>
    <td>Void</td>
    <td></td>
    <td></td>
    <td>Long id</td>
    <td>204</td>
  </tr>
</table>

### Uygulamadaki REST API'ler [BASE URL = /api/payment]

<table style="width:100%">
  <tr>
      <th>Metot</th>
      <th>Url</th>
      <th>Açıklama</th>
      <th>Response</th>
      <th>Request Body</th>
      <th>Request Param</th>
      <th>Path Variable</th>
      <th>HttpStatus</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>/all</td>
      <td>Oluşturulmuş Tüm Ödemeleri Getirir</td>
      <td>List<<Payment>Payment> getAllPayments</td>
      <td></td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/{id}</td>
      <td>id'ye göre ödemeyi getirir.</td>
      <td>ResponseEntity<<Payment>Payment> getPaymentById</td>
      <td></td>
      <td></td>
      <td>Long id</td>
      <td>200</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/create</td>
    <td>Ödemeyi oluşturur.</td>
    <td>Payment payment</td>
    <td>Payment payment</td>
    <td></td>
    <td></td>
    <td>201</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/{id}</td>
    <td>İlgili ödemenin bilgilerini günceller.</td>
    <td>Payment payment</td>
    <td>Payment updatedPayment</td>
    <td></td>
    <td>Long id</td>
    <td>200</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/{id}</td>
    <td>İlgili ödemeyi siler.</td>
    <td>Void</td>
    <td></td>
    <td></td>
    <td>Long id</td>
    <td>204</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/process</td>
    <td>Müşteri ödemesini işler.</td>
    <td>ResponseEntity<<Payment>Payment></td>
    <td></td>
    <td>
      Long policyId, 
      Long customerId, 
      double amount
    </td>
    <td></td>
    <td>200</td>
  </tr>
</table>

### Uygulamadaki REST API'ler [BASE URL = /api/policies]
<table style="width:100%">
  <tr>
      <th>Metot</th>
      <th>Url</th>
      <th>Açıklama</th>
      <th>Response</th>
      <th>Request Body</th>
      <th>Request Param</th>
      <th>Path Variable</th>
      <th>HttpStatus</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>/</td>
      <td>Oluşturulmuş Tüm Poliçeleri Getirir</td>
      <td>List<<Policy>Policy> getAllPolicies</td>
      <td></td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/{id}</td>
      <td>id'ye göre poliçeyi getirir.</td>
      <td>ResponseEntity<<Policy>Policy> getPolicyById</td>
      <td></td>
      <td></td>
      <td>Long id</td>
      <td>200</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/create</td>
    <td>Poliçeyi oluşturur.</td>
    <td>Policy policy</td>
    <td>Policy policy</td>
    <td></td>
    <td></td>
    <td>201</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/{id}</td>
    <td>İlgili poliçenin bilgilerini günceller.</td>
    <td>Policy policy</td>
    <td>Policy updatedPolicy</td>
    <td></td>
    <td>Long id</td>
    <td>200</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/{id}</td>
    <td>İlgili poliçeyi siler.</td>
    <td>Void</td>
    <td></td>
    <td></td>
    <td>Long id</td>
    <td>204</td>
  </tr>
</table>

### Uygulamadaki REST API'ler [BASE URL = /api/reports]
<table style="width:100%">
  <tr>
      <th>Metot</th>
      <th>Url</th>
      <th>Açıklama</th>
      <th>Response</th>
      <th>Request Body</th>
      <th>Request Param</th>
      <th>Path Variable</th>
      <th>HttpStatus</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>/total-revenue</td>
      <td>Toplam Geliri Getirir</td>
      <td>double getTotalRevenue</td>
      <td></td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/total-premium</td>
      <td>Toplam Primi Getirir</td>
      <td>double getTotalPremium</td>
      <td></td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
</table>
---
### Kullanılan Teknolojiler


- Java 17
- Spring Boot 3.2.5
- MySQL
- Postman
- Maven
- Restful API
---

### Uygulamayı ayağa kaldırmak için:

#### .env dosyasında değişkenler tanımlanmalıdır.

```
DB_USERNAME= {BURAYA_DB_USERNAME_YAZILMALI}
DB_PASSWORD= {BURAYA_DB_PASSWORD_YAZILMALI}
```
---

### Maven ile çalıştırmak için
Aşağıdaki adımlar takip edilir.

```sh
$ cd Insurance-Account-Management-System-Application
$ mvn clean install
$ mvn spring-boot:run
```