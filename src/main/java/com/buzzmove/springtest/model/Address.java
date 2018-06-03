package com.buzzmove.springtest.model;

public class Address {
	
	private String addressPrincipal;
	private String addressSecondary ;
	private String town  ;
	private String county ;
	private String postcode ;
	
	public String getAddressPrincipal() {
		return addressPrincipal;
	}
	public void setAddressPrincipal(String addressPrincipal) {
		this.addressPrincipal = addressPrincipal;
	}
	public String getAddressSecondary() {
		return addressSecondary;
	}
	public void setAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((addressPrincipal == null) ? 0 : addressPrincipal.hashCode());
		result = prime
				* result
				+ ((addressSecondary == null) ? 0 : addressSecondary.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressPrincipal == null) {
			if (other.addressPrincipal != null)
				return false;
		} else if (!addressPrincipal.equals(other.addressPrincipal))
			return false;
		if (addressSecondary == null) {
			if (other.addressSecondary != null)
				return false;
		} else if (!addressSecondary.equals(other.addressSecondary))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [addressPrincipal=" + addressPrincipal
				+ ", addressSecondary=" + addressSecondary + ", town=" + town
				+ ", county=" + county + ", postcode=" + postcode + "]";
	}
}
