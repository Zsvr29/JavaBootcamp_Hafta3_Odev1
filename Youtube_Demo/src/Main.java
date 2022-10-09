
public class Main {

	public static void main(String[] args) {
		
		
	
	
	
	


		CreditManager creditManager = new CreditManager();// new yaptıgımız kısım heap kısmı oluyor.burda referans
															// olusuyor.

	creditManager.Calculate();
		creditManager.Save();

		Customer customer = new Customer(); // Constructer

		customer.id = 1;
		customer.City = "Ankara";
		

		CustomerManager customerManager = new CustomerManager (customer); // customer ekledık. Constructer.

		customerManager.Save();
		customerManager.Delete();

		Company company = new Company();
		company.TaxNumber = "12345678";
		company.CompanyName="Arcelik";
		company.id=100;
		
		
		CustomerManager customerManager2=new CustomerManager(new Person());
	
		//Person person = new Person();
		//person.nationalIdentity = "123456";
		//person.firstName="";
		
		//Customer c1=new Customer();
		//Customer c2=new Person();
		//Customer c3= new Company();

	}



class CreditManager {

	public void Calculate() // Metod
	{
		System.out.println("Hesaplandı");
	}

	public void Save() {
		System.out.println("Kredi verildi.");
	}
}



interface ICreditManager { // ıkı tane kredı yontecıım var bırı calculate yapıyor dıgerı save. 
	
	void Calculate(); //  buna imza deniliyor. Bu da methodun sadece ne donddurdugunu,ismini, parametrelerini 
	void Save();

}

abstract class BaseCreditManager implements ICreditManager{
	
	
	
}

class TeacherCreditManager implements ICreditManager { // interface // bu class bu ınterfacenınn operasyonlarını doldurmak zorundadır.
	

	@Override
	public void Calculate() {
		
		System.out.println("Öğretmen kredisi hesaplandı");
	}

	@Override
	public void Save() {
		
	}
	
}

class MilitaryCreditManager implements ICreditManager{

	@Override
	public void Calculate() {
		System.out.println("Asker kredısı hesaplandı");
		
	}

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		
	}  // interface 
	
	
	
}


//TEMEL SINIF 
  class Customer { // ozellik // Temel nesne burdan ınherıtance yaptık.
	 //bir class sadece bir işi yapabılır. BUrda sadece ozellık tutuyor eger
	// fonksıyon eklersek solıd olmaz.

   public Customer() { // Constructer
		System.out.println("Musterı nesnesı baslatıldı.");

	}

	public int id;
	public String City;

}

  //INHERİTANCE
class Person extends Customer {

	public String nationalIdentity;
	public String firstName;
	public String lastName;

  }

// INHERİTANCE 
class Company extends Customer {// ınherıtance
	public String CompanyName;
	public String TaxNumber;

  }

// Katmanlı Mimariler için temeldir. Gorevler bırbırınden ayrıldı.

class CustomerManager {
	private Customer _customer;
	private CreditManager _creditManager;

	public CustomerManager(Customer customer,CreditManager creditManager) {//polimorfizm
		_customer = customer;
		_creditManager=creditManager;

	}

	public void Save( /* Customer customer */) // musterı nesnesını parametre olarak gonderdık. Encapsulatıon
	{
		System.out.println("Mütseri kaydedıldi." );

	}

	public void Delete() {
		System.out.println("Musterı sılındı" );
	}
	
	public void GiveCredit() {
		_creditManager.Calculate();
		System.out.println("Kredi verildi");
		
	}

}
}