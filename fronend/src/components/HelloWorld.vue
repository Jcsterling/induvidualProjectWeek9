<template>
<div class="hello">
<h1>{{ msg }}</h1>
<h2>Add Account</h2>
<form action="/action_page.php">
  <fieldset>
    <legend>Personal information:</legend>
    First name:<br>
    <input v-model="AccountHolder.firstname" type="text" name="firstname" placeholder="Enter first name">
    <br>
    Last name:<br>
    <input v-model="AccountHolder.lastname" name="lastname" type="text"  >
    <br>
    Account number:<br>
    <input type="text" name="accountNumber" v-model="AccountHolder.accountNumber" >
    <br><br>
    <input type="submit" v-on:click="addToAPI" value="Submit">
  </fieldset>
</form>
 </div>
 </template>
<script>
/*eslint-disable*/
import axios from 'axios';
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'JCSterling Account Management System ',
      AccountHolder : {firstname:'', lastname:'', accountNumber:''}
    }
  },methods: {
  
  addToAPI(){
  axios.post('/Account', {
    firstname : this.AccountHolder.firstname,
    lastname : this.AccountHolder.lastname,
    accountNumber : this.AccountHolder.accountNumber, 
  })
  .catch(e => {
  this.errors.push(e)})
  }
  }
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
