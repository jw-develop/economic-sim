package simulator;

public class Initialize {
	//Worksites
	//Resource abstract type
		//Food v. other?
	worksites.add(new Resource("Farmland","farming",50000,1900,.01));
	worksites.add(new Resource("Forest","hunting",50000,2100,.05));
	
	for (Resource site : worksites)
		jobs.put(site.getWorkType(),new Job(site));
	
	//People
	Person walter = new Person(this,"Charles","Smith");
	walter.addSkill(new Skill("farming",5));
	walter.addGood(new Good("food",5000));
	folks.add(walter);
	
	Person shims = new Person(this,"Shims","White");
	shims.addSkill(new Skill("farming",7));
	shims.addGood(new Good("food",3000));
	folks.add(shims);

	Person babs = new Person(this,"Dej","Denver");
	babs.addSkill(new Skill("hunting",3));
	babs.addGood(new Good("food",2500));
	folks.add(babs);
}
