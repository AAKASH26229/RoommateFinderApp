/**
 * 
 */

		$(function() {
			var $registerForm = $("#register");

			$registerForm.validate({
				rules : {
					fname : {
						required : true,
						lattersonly : true
					},
					lname : {
						required : true,
						lattersonly : true
					},
					email : {
						required : true,
						email : true
					},
					mobile : {
						required : true,
						numericonly : true,
						minlength : 10,
						maxlength : 12
					},
					gender : {
						required : true
					},
					role : {
						required : true
					},
					shift : {
						required : true
					},
					occupancy : {
						required : true
					},
					password : {
						required : true,
						all : true
					},
					cpassword : {
						required : true,
						equalTo : '#password'
					}

				},
				messages : {
					username : {
						required : 'username must be required',
						lattersonly : 'invalid name'
					},

					email : {
						required : 'email must be required',
						email : 'email invalid'
					},
					mobile : {
						required : 'phno must be required',
						numericonly : 'Phno invalid',
						minlength : 'min 10 digit',
						maxlength : 'mx 12 digit'
					},
					gender : {
						required : 'gender must be required'
					},
					role : {
						required : 'course must be required'
					},
					shift : {
						required : 'course must be required'
					},
					occupancy : {
						required : 'course must be required'
					},

					password : {
						required : 'password must be required',
						all : 'space is not allowed'
					},
					cpassword : {
						required : 'confirm password must be required',
						equalTo : 'password mismatch'
					}
				},
				errorPlacement : function(error, element) {
					if (element.is(":select")) {
						error.appendTo(element.parents(".gender"));
					} else {
						error.insertAfter(element);
					}
				}
			})

			jQuery.validator.addMethod('lattersonly', function(value, element) {
				return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
			});

			jQuery.validator.addMethod('numericonly', function(value, element) {
				return /^[0-9]+$/.test(value);
			});

			jQuery.validator.addMethod('all', function(value, element) {
				return /^[^-\s][a-zA-Z0-9_\s-]+$/.test(value);
			});
		})