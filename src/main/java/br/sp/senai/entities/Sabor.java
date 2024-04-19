package br.sp.senai.entities;

public class Sabor {
	private Integer id;
	private String name;
	private String desc;
	private Double price;
	
	public Sabor() {
		
	}
	
	public Sabor(Integer id, String name, String desc, Double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		
		if(obj.getClass().equals(this.getClass())) {
			Sabor sabor = (Sabor) obj;
			
			return sabor.getId().equals(this.getId());
		}else {
			return false;
		}
	}
}
