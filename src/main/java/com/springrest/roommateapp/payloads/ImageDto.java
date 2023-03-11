package com.springrest.roommateapp.payloads;


public class ImageDto {

		private Long id;

		
		private String name;

	    private byte[] data;
	    

	    public ImageDto() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public byte[] getData() {
			return data;
		}


		public void setData(byte[] data) {
			this.data = data;
		}
	    
	    
}
