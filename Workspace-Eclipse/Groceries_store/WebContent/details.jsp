<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jotfor.ms/static/formCss.css?3.3.15179"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="https://cdn.jotfor.ms/css/styles/nova.css?3.3.15179" />
<link type="text/css" media="print" rel="stylesheet"
	href="https://cdn.jotfor.ms/css/printForm.css?3.3.15179" />

<style type="text/css">
.form-label-left {
	width: 150px !important;
}

.form-line {
	padding-top: 12px;
	padding-bottom: 12px;
}

.form-label-right {
	width: 150px !important;
}

body, html {
	margin: 0;
	padding: 0;
	background: false;
}

.form-all {
	margin: 0px auto;
	padding-top: 0px;
	width: 590px;
	color: Black !important;
	font-family: "Lucida Grande", "Lucida Sans Unicode", "Lucida Sans",
		Verdana, sans-serif;
	font-size: 14px;
}
</style>
</head>
<body>


	<form class="jotform-form" action="payment.jsp" method="post"
		accept-charset="utf-8" >
		<div class="form-all">
			<ul class="form-section page-section">
				<li id="cid_18" class="form-input-wide" data-type="control_head">
					<div class="form-header-group">
						<div class="header-text httal htvam">
							<h1 id="header_18" class="form-header">Please enter details
							</h1>
						</div>
					</div>
				</li>
				<li class="form-line" data-type="control_fullname" id="id_19">
					<label class="form-label form-label-top form-label-auto"
					id="label_19" for="input_19"> Name </label>
					<div id="cid_19" class="form-input-wide jf-required">
						<span class="form-sub-label-container" style="vertical-align: top">
							<input class="form-textbox" type="text" size="10"
							name="q19_name[first]" id="first_19" required="true" /> <label
							class="form-sub-label" for="first_19" id="sublabel_first"
							style="min-height: 13px;"> First Name </label>
						</span> <span class="form-sub-label-container"
							style="vertical-align: top"> <input class="form-textbox"
							type="text" size="15" name="q19_name[last]" id="last_19" required="true"/> <label
							class="form-sub-label" for="last_19" id="sublabel_last"
							style="min-height: 13px;"> Last Name </label>
						</span>
					</div>
				</li>
				<li class="form-line" data-type="control_phone" id="id_22"><label
					class="form-label form-label-top form-label-auto" id="label_22"
					for="input_22"> Phone Number </label>
					<div id="cid_22" class="form-input-wide jf-required">
						<span class="form-sub-label-container" style="vertical-align: top">
							<input class="form-textbox" type="tel"
							name="q22_phoneNumber[area]" id="input_22_area" size="3" required="true">
							<span class="phone-separate"> &nbsp;- </span> <label
							class="form-sub-label" for="input_22_area" id="sublabel_area"
							style="min-height: 13px;"> Area Code </label>
						</span> <span class="form-sub-label-container"
							style="vertical-align: top"> <input class="form-textbox"
							type="tel" name="q22_phoneNumber[phone]" id="input_22_phone"
							size="8" required="true"> <label class="form-sub-label"
							for="input_22_phone" id="sublabel_phone"
							style="min-height: 13px;"> Phone Number </label>
						</span>
					</div></li>
				<li class="form-line" data-type="control_email" id="id_20"><label
					class="form-label form-label-top form-label-auto" id="label_20"
					for="input_20"> E-mail </label>
					<div id="cid_20" class="form-input-wide jf-required">
						<input type="email" class=" form-textbox validate[Email]"
							id="input_20" name="q20_email" size="30" value="" required="true"/>
					</div></li>
				<li class="form-line" data-type="control_address" id="id_21"><label
					class="form-label form-label-top form-label-auto" id="label_21"
					for="input_21"> Address </label>
					<div id="cid_21" class="form-input-wide jf-required">
						<table summary="" undefined class="form-address-table" border="0"
							cellpadding="0" cellspacing="0">
							<tr>
								<td colspan="2"><span class="form-sub-label-container"
									style="vertical-align: top"> <input
										class="form-textbox form-address-line" type="text"
										name="q21_address[addr_line1]" id="input_21_addr_line1" required="true"/> <label
										class="form-sub-label" for="input_21_addr_line1"
										id="sublabel_21_addr_line1" style="min-height: 13px;">
											Street Address </label>
								</span></td>
							</tr>
							<tr>
								<td colspan="2"><span class="form-sub-label-container"
									style="vertical-align: top"> <input
										class="form-textbox form-address-line" type="text"
										name="q21_address[addr_line2]" id="input_21_addr_line2"
										size="46" required="true"/> <label class="form-sub-label"
										for="input_21_addr_line2" id="sublabel_21_addr_line2"
										style="min-height: 13px;"> Street Address Line 2 </label>
								</span></td>
							</tr>
							<tr>
								<td width="50%"><span class="form-sub-label-container"
									style="vertical-align: top"> <input
										class="form-textbox form-address-city" type="text"
										name="q21_address[city]" id="input_21_city" size="21" required="true"/> <label
										class="form-sub-label" for="input_21_city"
										id="sublabel_21_city" style="min-height: 13px;"> City
									</label>
								</span></td>
								<td><span class="form-sub-label-container"
									style="vertical-align: top"> <input
										class="form-textbox form-address-state" type="text"
										name="q21_address[state]" id="input_21_state" required="true" size="22" /> <label
										class="form-sub-label" for="input_21_state"
										id="sublabel_21_state" style="min-height: 13px;">
											State / Province </label>
								</span></td>
							</tr>
							<tr>
								<td width="50%"><span class="form-sub-label-container"
									style="vertical-align: top"> <input
										class="form-textbox form-address-postal" type="text"
										name="q21_address[postal]" id="input_21_postal" size="10" required="true"/>
										<label class="form-sub-label" for="input_21_postal"
										id="sublabel_21_postal" style="min-height: 13px;">
											Postal / Zip Code </label>
								</span></td>
								<td><span class="form-sub-label-container"
									style="vertical-align: top"> <select
										class="form-dropdown form-address-country" defaultcountry=""
										name="q21_address[country]" id="input_21_country">
											<option value="" selected>Please Select</option>
											<option value="United States">United States</option>
											<option value="Afghanistan">Afghanistan</option>
											<option value="Albania">Albania</option>
											<option value="Algeria">Algeria</option>
											<option value="American Samoa">American Samoa</option>
											<option value="Andorra">Andorra</option>
											<option value="Angola">Angola</option>
											<option value="Anguilla">Anguilla</option>
											<option value="Antigua and Barbuda">Antigua and
												Barbuda</option>
											<option value="Argentina">Argentina</option>
											<option value="Armenia">Armenia</option>
											<option value="Aruba">Aruba</option>
											<option value="Australia">Australia</option>
											<option value="Austria">Austria</option>
											<option value="Azerbaijan">Azerbaijan</option>
											<option value="The Bahamas">The Bahamas</option>
											<option value="Bahrain">Bahrain</option>
											<option value="Bangladesh">Bangladesh</option>
											<option value="Barbados">Barbados</option>
											<option value="Belarus">Belarus</option>
											<option value="Belgium">Belgium</option>
											<option value="Belize">Belize</option>
											<option value="Benin">Benin</option>
											<option value="Bermuda">Bermuda</option>
											<option value="Bhutan">Bhutan</option>
											<option value="Bolivia">Bolivia</option>
											<option value="Bosnia and Herzegovina">Bosnia and
												Herzegovina</option>
											<option value="Botswana">Botswana</option>
											<option value="Brazil">Brazil</option>
											<option value="Brunei">Brunei</option>
											<option value="Bulgaria">Bulgaria</option>
											<option value="Burkina Faso">Burkina Faso</option>
											<option value="Burundi">Burundi</option>
											<option value="Cambodia">Cambodia</option>
											<option value="Cameroon">Cameroon</option>
											<option value="Canada">Canada</option>
											<option value="Cape Verde">Cape Verde</option>
											<option value="Cayman Islands">Cayman Islands</option>
											<option value="Central African Republic">Central
												African Republic</option>
											<option value="Chad">Chad</option>
											<option value="Chile">Chile</option>
											<option value="China">China</option>
											<option value="Christmas Island">Christmas Island</option>
											<option value="Cocos (Keeling) Islands">Cocos
												(Keeling) Islands</option>
											<option value="Colombia">Colombia</option>
											<option value="Comoros">Comoros</option>
											<option value="Congo">Congo</option>
											<option value="Cook Islands">Cook Islands</option>
											<option value="Costa Rica">Costa Rica</option>
											<option value="Cote d'Ivoire">Cote d'Ivoire</option>
											<option value="Croatia">Croatia</option>
											<option value="Cuba">Cuba</option>
											<option value="Cyprus">Cyprus</option>
											<option value="Czech Republic">Czech Republic</option>
											<option value="Democratic Republic of the Congo">
												Democratic Republic of the Congo</option>
											<option value="Denmark">Denmark</option>
											<option value="Djibouti">Djibouti</option>
											<option value="Dominica">Dominica</option>
											<option value="Dominican Republic">Dominican
												Republic</option>
											<option value="Ecuador">Ecuador</option>
											<option value="Egypt">Egypt</option>
											<option value="El Salvador">El Salvador</option>
											<option value="Equatorial Guinea">Equatorial Guinea
											</option>
											<option value="Eritrea">Eritrea</option>
											<option value="Estonia">Estonia</option>
											<option value="Ethiopia">Ethiopia</option>
											<option value="Falkland Islands">Falkland Islands</option>
											<option value="Faroe Islands">Faroe Islands</option>
											<option value="Fiji">Fiji</option>
											<option value="Finland">Finland</option>
											<option value="France">France</option>
											<option value="French Polynesia">French Polynesia</option>
											<option value="Gabon">Gabon</option>
											<option value="The Gambia">The Gambia</option>
											<option value="Georgia">Georgia</option>
											<option value="Germany">Germany</option>
											<option value="Ghana">Ghana</option>
											<option value="Gibraltar">Gibraltar</option>
											<option value="Greece">Greece</option>
											<option value="Greenland">Greenland</option>
											<option value="Grenada">Grenada</option>
											<option value="Guadeloupe">Guadeloupe</option>
											<option value="Guam">Guam</option>
											<option value="Guatemala">Guatemala</option>
											<option value="Guernsey">Guernsey</option>
											<option value="Guinea">Guinea</option>
											<option value="Guinea-Bissau">Guinea-Bissau</option>
											<option value="Guyana">Guyana</option>
											<option value="Haiti">Haiti</option>
											<option value="Honduras">Honduras</option>
											<option value="Hong Kong">Hong Kong</option>
											<option value="Hungary">Hungary</option>
											<option value="Iceland">Iceland</option>
											<option value="India">India</option>
											<option value="Indonesia">Indonesia</option>
											<option value="Iran">Iran</option>
											<option value="Iraq">Iraq</option>
											<option value="Ireland">Ireland</option>
											<option value="Israel">Israel</option>
											<option value="Italy">Italy</option>
											<option value="Jamaica">Jamaica</option>
											<option value="Japan">Japan</option>
											<option value="Jersey">Jersey</option>
											<option value="Jordan">Jordan</option>
											<option value="Kazakhstan">Kazakhstan</option>
											<option value="Kenya">Kenya</option>
											<option value="Kiribati">Kiribati</option>
											<option value="North Korea">North Korea</option>
											<option value="South Korea">South Korea</option>
											<option value="Kosovo">Kosovo</option>
											<option value="Kuwait">Kuwait</option>
											<option value="Kyrgyzstan">Kyrgyzstan</option>
											<option value="Laos">Laos</option>
											<option value="Latvia">Latvia</option>
											<option value="Lebanon">Lebanon</option>
											<option value="Lesotho">Lesotho</option>
											<option value="Liberia">Liberia</option>
											<option value="Libya">Libya</option>
											<option value="Liechtenstein">Liechtenstein</option>
											<option value="Lithuania">Lithuania</option>
											<option value="Luxembourg">Luxembourg</option>
											<option value="Macau">Macau</option>
											<option value="Macedonia">Macedonia</option>
											<option value="Madagascar">Madagascar</option>
											<option value="Malawi">Malawi</option>
											<option value="Malaysia">Malaysia</option>
											<option value="Maldives">Maldives</option>
											<option value="Mali">Mali</option>
											<option value="Malta">Malta</option>
											<option value="Marshall Islands">Marshall Islands</option>
											<option value="Martinique">Martinique</option>
											<option value="Mauritania">Mauritania</option>
											<option value="Mauritius">Mauritius</option>
											<option value="Mayotte">Mayotte</option>
											<option value="Mexico">Mexico</option>
											<option value="Micronesia">Micronesia</option>
											<option value="Moldova">Moldova</option>
											<option value="Monaco">Monaco</option>
											<option value="Mongolia">Mongolia</option>
											<option value="Montenegro">Montenegro</option>
											<option value="Montserrat">Montserrat</option>
											<option value="Morocco">Morocco</option>
											<option value="Mozambique">Mozambique</option>
											<option value="Myanmar">Myanmar</option>
											<option value="Nagorno-Karabakh">Nagorno-Karabakh</option>
											<option value="Namibia">Namibia</option>
											<option value="Nauru">Nauru</option>
											<option value="Nepal">Nepal</option>
											<option value="Netherlands">Netherlands</option>
											<option value="Netherlands Antilles">Netherlands
												Antilles</option>
											<option value="New Caledonia">New Caledonia</option>
											<option value="New Zealand">New Zealand</option>
											<option value="Nicaragua">Nicaragua</option>
											<option value="Niger">Niger</option>
											<option value="Nigeria">Nigeria</option>
											<option value="Niue">Niue</option>
											<option value="Norfolk Island">Norfolk Island</option>
											<option value="Turkish Republic of Northern Cyprus">
												Turkish Republic of Northern Cyprus</option>
											<option value="Northern Mariana">Northern Mariana</option>
											<option value="Norway">Norway</option>
											<option value="Oman">Oman</option>
											<option value="Pakistan">Pakistan</option>
											<option value="Palau">Palau</option>
											<option value="Palestine">Palestine</option>
											<option value="Panama">Panama</option>
											<option value="Papua New Guinea">Papua New Guinea</option>
											<option value="Paraguay">Paraguay</option>
											<option value="Peru">Peru</option>
											<option value="Philippines">Philippines</option>
											<option value="Pitcairn Islands">Pitcairn Islands</option>
											<option value="Poland">Poland</option>
											<option value="Portugal">Portugal</option>
											<option value="Puerto Rico">Puerto Rico</option>
											<option value="Qatar">Qatar</option>
											<option value="Republic of the Congo">Republic of
												the Congo</option>
											<option value="Romania">Romania</option>
											<option value="Russia">Russia</option>
											<option value="Rwanda">Rwanda</option>
											<option value="Saint Barthelemy">Saint Barthelemy</option>
											<option value="Saint Helena">Saint Helena</option>
											<option value="Saint Kitts and Nevis">Saint Kitts
												and Nevis</option>
											<option value="Saint Lucia">Saint Lucia</option>
											<option value="Saint Martin">Saint Martin</option>
											<option value="Saint Pierre and Miquelon">Saint
												Pierre and Miquelon</option>
											<option value="Saint Vincent and the Grenadines">
												Saint Vincent and the Grenadines</option>
											<option value="Samoa">Samoa</option>
											<option value="San Marino">San Marino</option>
											<option value="Sao Tome and Principe">Sao Tome and
												Principe</option>
											<option value="Saudi Arabia">Saudi Arabia</option>
											<option value="Senegal">Senegal</option>
											<option value="Serbia">Serbia</option>
											<option value="Seychelles">Seychelles</option>
											<option value="Sierra Leone">Sierra Leone</option>
											<option value="Singapore">Singapore</option>
											<option value="Slovakia">Slovakia</option>
											<option value="Slovenia">Slovenia</option>
											<option value="Solomon Islands">Solomon Islands</option>
											<option value="Somalia">Somalia</option>
											<option value="Somaliland">Somaliland</option>
											<option value="South Africa">South Africa</option>
											<option value="South Ossetia">South Ossetia</option>
											<option value="South Sudan">South Sudan</option>
											<option value="Spain">Spain</option>
											<option value="Sri Lanka">Sri Lanka</option>
											<option value="Sudan">Sudan</option>
											<option value="Suriname">Suriname</option>
											<option value="Svalbard">Svalbard</option>
											<option value="Swaziland">Swaziland</option>
											<option value="Sweden">Sweden</option>
											<option value="Switzerland">Switzerland</option>
											<option value="Syria">Syria</option>
											<option value="Taiwan">Taiwan</option>
											<option value="Tajikistan">Tajikistan</option>
											<option value="Tanzania">Tanzania</option>
											<option value="Thailand">Thailand</option>
											<option value="Timor-Leste">Timor-Leste</option>
											<option value="Togo">Togo</option>
											<option value="Tokelau">Tokelau</option>
											<option value="Tonga">Tonga</option>
											<option value="Transnistria Pridnestrovie">
												Transnistria Pridnestrovie</option>
											<option value="Trinidad and Tobago">Trinidad and
												Tobago</option>
											<option value="Tristan da Cunha">Tristan da Cunha</option>
											<option value="Tunisia">Tunisia</option>
											<option value="Turkey">Turkey</option>
											<option value="Turkmenistan">Turkmenistan</option>
											<option value="Turks and Caicos Islands">Turks and
												Caicos Islands</option>
											<option value="Tuvalu">Tuvalu</option>
											<option value="Uganda">Uganda</option>
											<option value="Ukraine">Ukraine</option>
											<option value="United Arab Emirates">United Arab
												Emirates</option>
											<option value="United Kingdom">United Kingdom</option>
											<option value="Uruguay">Uruguay</option>
											<option value="Uzbekistan">Uzbekistan</option>
											<option value="Vanuatu">Vanuatu</option>
											<option value="Vatican City">Vatican City</option>
											<option value="Venezuela">Venezuela</option>
											<option value="Vietnam">Vietnam</option>
											<option value="British Virgin Islands">British
												Virgin Islands</option>
											<option value="Isle of Man">Isle of Man</option>
											<option value="US Virgin Islands">US Virgin Islands
											</option>
											<option value="Wallis and Futuna">Wallis and Futuna
											</option>
											<option value="Western Sahara">Western Sahara</option>
											<option value="Yemen">Yemen</option>
											<option value="Zambia">Zambia</option>
											<option value="Zimbabwe">Zimbabwe</option>
											<option value="other">Other</option>
									</select> <label class="form-sub-label" for="input_21_country"
										id="sublabel_21_country" style="min-height: 13px;">
											Country </label>
								</span></td>
							</tr>
						</table>
					</div></li>
				<li class="form-line" data-type="control_button" id="id_14">
					<div id="cid_14" class="form-input-wide">
						<div style="text-align: center" class="form-buttons-wrapper">
							<button id="input_14" type="submit" class="form-submit-button">
								Submit</button>
						</div>
					</div>
				</li> 	
			</ul>
		</div>
		
	</form>
</body>
</html>