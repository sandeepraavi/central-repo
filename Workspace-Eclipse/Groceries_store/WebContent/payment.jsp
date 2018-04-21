<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link href="https://cdn.jotfor.ms/static/formCss.css?3.3.15179" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/css/styles/nova.css?3.3.15179" />
<link type="text/css" media="print" rel="stylesheet" href="https://cdn.jotfor.ms/css/printForm.css?3.3.15179" />
<style type="text/css">
    .form-label-left{
        width:150px !important;
    }
    .form-line{
        padding-top:12px;
        padding-bottom:12px;
    }
    .form-label-right{
        width:150px !important;
    }
    body, html{
        margin:0;
        padding:0;
        background:false;
    }

    .form-all{
        margin:0px auto;
        padding-top:0px;
        width:590px;
        color:Black !important;
        font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Verdana, sans-serif;
        font-size:14px;
    }
</style>
</head>
<body>
<form class="jotform-form" action="final.jsp" method="post" accept-charset="utf-8">
  <div class="form-all">
    <ul class="form-section page-section">
      <li id="cid_18" class="form-input-wide" data-type="control_head">
        <div class="form-header-group">
          <div class="header-text httal htvam">
            <h1 id="header_18" class="form-header">
              Please enter card details
            </h1>
          </div>
        </div>
      </li>
       <li class="form-line" data-type="control_address" id="id_26">
        <label class="form-label form-label-top form-label-auto" id="label_26" for="input_26"> Card type </label>
        <div id="cid_26" class="form-input-wide jf-required">
          <table summary="" undefined="" class="form-address-table" border="0" cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
              <td width="50%">
                <span class="form-sub-label-container" style="vertical-align: top">
                  <input  type="radio" name="card" id="input_26" required="true">
                  <label  for="input_26" id="sublabel_21_city" style="min-height: 13px;"> Debit card </label>
                </span>
              </td>
              <td>
                <span class="form-sub-label-container" style="vertical-align: top">
                  <input type="radio" name="card" id="input_27" required="true">
                  <label  for="input_27" id="sublabel_21_state" style="min-height: 13px;"> Credit card </label>
                </span>
              </td>
            </tr>
            
          </tbody></table>
        </div>
      </li>
      <li class="form-line" data-type="control_fullname" id="id_19">
        <label class="form-label form-label-top form-label-auto" id="label_19" for="input_19"> Name on card </label>
        <div id="cid_19" class="form-input-wide jf-required">
            <input class="form-textbox" type="text" name="q19_name[first]" size="30" id="first_19" required="true"/>
        </div>
      </li>
      <li class="form-line" data-type="control_email" id="id_20">
        <label class="form-label form-label-top form-label-auto" id="label_20" for="input_20"> Number on card </label>
        <div id="cid_20" class="form-input-wide jf-required">
          <input type="number" class=" form-textbox validate[Email]" id="input_20" name="q20_email" size="30" value="" required="true"/>
        </div>
      </li>
      <li class="form-line" data-type="control_address" id="id_21">
        <label class="form-label form-label-top form-label-auto" id="label_21" for="input_21"> Expiry date </label>
        <div id="cid_21" class="form-input-wide jf-required">
          <table summary="" undefined="" class="form-address-table" border="0" cellpadding="0" cellspacing="0">
            <tbody>
            
            <tr>
              <td width="50%">
                <span class="form-sub-label-container" style="vertical-align: top">
                  <input class="form-textbox form-address-city" type="text" name="q21_address[city]" id="input_21_city" size="21" required="true">
                  <label class="form-sub-label" for="input_21_city" id="sublabel_21_city" style="min-height: 13px;"> MM/YY </label>
                </span>
              </td>
              <td>
                <span class="form-sub-label-container" style="vertical-align: top">
                  <input class="form-textbox form-address-state" type="number" name="q21_address[state]" id="input_21_state" size="22" required="true">
                  <label class="form-sub-label" for="input_21_state" id="sublabel_21_state" style="min-height: 13px;"> CVV number </label>
                </span>
              </td>
            </tr>
            
          </tbody></table>
        </div>
      </li>
    
      <li class="form-line" data-type="control_button" id="id_14">
        <div id="cid_14" class="form-input-wide">
          <div style="text-align:center" class="form-buttons-wrapper">
            <button id="input_14" type="submit" class="form-submit-button">
              Submit
            </button>
          </div>
        </div>
      </li>
    </ul>
  </div>
 
</form></body>
</html>