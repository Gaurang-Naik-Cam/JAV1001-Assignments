package com.example.mycontactsapp

 class Customer(){
    lateinit var Name : String
    lateinit var PhoneNumber : String
    var ImageId : Int = R.id.imgDefault

    constructor(_name:String , _phoneNumber : String) : this() {
        this.Name = _name
        this.PhoneNumber = _phoneNumber
    }
}
