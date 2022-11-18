<template>
<!--country select-->
<div style="width: 800px ">
  <!--el-select v-model="country" placeholder="please choose a country">
    <el-option
      v-for="item in options1"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-button @click="click">test</el-button>

<blank line-->
<div style="margin: 15px 0"></div>

<!--industry-->
  <!--el-select v-model="industry" placeholder="please choose a industry name">
    <el-option
      v-for="item in options2"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select-->

<!--form-->
<!-------------------------------------------------------------->
<!-------------------------------------------------------------->
<!-------------------------------------------------------------->
<!-------------------------------------------------------------->

<el-form ref="form" :model="form" :rules="rules"
size="mini" label-width="200px" :label-position="left_form">

   <el-form-item label="Date of valuation" label-width="300px" required>
    <el-col :span="11">
      <el-form-item prop="date1">
        <el-date-picker type="date" placeholder="Please choose a date" v-model="form.date1" style="width: 100%;"></el-date-picker>
      </el-form-item>
    </el-col>
    <!--el-col class="line" :span="2">-</el-col-->
  </el-form-item>
  
  <el-form-item label="Company name" label-width="300px" prop="name">
    <el-input v-model="form.name"></el-input>
  </el-form-item>
  <el-button @click="click">test1</el-button>

  <el-form-item label="region" label-width="400px" prop="region">
    <el-select v-model="form.region" placeholder="">
      <el-option label="United Kingdom" value="shanghai"></el-option>
      <el-option label="United States" value="beijing"></el-option>
    </el-select>
  </el-form-item>

   <el-form-item label="industry" label-width="400px" prop="industry">
    <el-select v-model="form.industry" placeholder="">
      <el-option label="Aerospace/Defense" value="aero"></el-option>
      <el-option label="Airtransport" value="CS"></el-option>
    </el-select>
  </el-form-item>

<!-------------------------------------------------------->
<!--revenue-->
  <el-form-item label="revenue" label-width="400px" prop="revenue1">
    <el-input v-model.number="form.revenue1"
    type="number" placeholder="please input revenue ($)">
      <i slot="suffix">$</i>
    </el-input>
  </el-form-item>
  <el-button @click="click2">test</el-button>

<!-------------------------------------------------------->
<!--EBIT-->
  <el-form-item label="EBIT" label-width="400px" prop="EBIT">
    <el-input v-model="form.EBIT" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Interest expense-->
  <el-form-item label="Interest expense" label-width="400px" prop="Interest_expense">
    <el-input v-model="form.Interest_expense" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Book value of equity-->
  <el-form-item label="Book value of equity" label-width="400px" prop="val_equity">
    <el-input v-model="form.val_equity" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Book value of debt-->
  <el-form-item label="Book value of debt" label-width="400px" prop="val_debt">
    <el-input v-model="form.val_debt" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--R&D expenses to capitalize-->
  <el-form-item label="R&D?"  label-width="400px">
    <el-switch v-model="form.R_and_D" 
    active-text="Yes" inactive-text="No"></el-switch>
  </el-form-item>

<!-------------------------------------------------------->
<!--Cash and Marketable Securities-->
  <el-form-item label="Cash and Marketable Securities" label-width="400px" prop="cash_securities">
    <el-input v-model="form.cash_securities" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>  

<!-------------------------------------------------------->
<!--Cross holdings and other non-operating assets-->
  <el-form-item label="Cross holdings and other non-operating assets" prop="other_assets"
   label-width="400px">
    <el-input v-model="form.other_assets" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Minority interests-->
  <el-form-item label="Minority interests" label-width="400px" prop="minor_int">
    <el-input v-model="form.minor_int" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>  

<!-------------------------------------------------------->
<!--Number of shares outstanding-->
  <el-form-item label="Number of shares outstanding" label-width="400px" prop="out_share">
    <el-input v-model="form.out_share" type="number"></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Current stock price-->
  <el-form-item label="Current stock price" label-width="400px" prop="cur_price">
    <el-input v-model="form.cur_price" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!--Effective tax rate-->
  <el-form-item label="Effective tax rate" label-width="400px" prop="tax_rate">
    <el-input v-model="form.tax_rate" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Marginal tax rate-->
  <el-form-item label="Marginal tax rate" label-width="400px" prop="mae_tax_rate">
    <el-input v-model="form.mar_tax_rate" type="number"><i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Revenue growth rate for next year-->
  <el-form-item label="Revenue growth rate for next year" label-width="400px" prop="rev_groth1">
    <el-input v-model="form.rev_growth1" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Operating Margin for next year-->
  <el-form-item label="Operating Margin for next year" label-width="400px" prop="ope_mar1">
    <el-input v-model="form.ope_mar1" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Compounded annual revenue growth rate - years 2-5-->
  <el-form-item label="Revenue growth rate years 2-5" label-width="400px" prop="rev_groth2_5">
    <el-input v-model="form.rev_growth2_5" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Target pre-tax operating margin (EBIT as % of sales in year 10)-->
  <el-form-item label="Target pre-tax operating margin" label-width="400px" prop="EBIT_Y10">
    <el-input v-model="form.EBIT_Y10" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!--Year of convergence-->
  <el-form-item label="Year of convergence" label-width="400px" prop="covergence">
    <el-input v-model="form.convergence" type="number"></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Sales to capital ratio (for computing reinvestment)-->
  <el-form-item label="Sales to capital ratio" label-width="400px" prop="sales_to_cap">
    <el-input v-model="form.sales_to_cap" type="number"></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!--Riskfree rate-->
  <el-form-item label="Sales to capital ratio" label-width="400px" prop="risk_rate">
    <el-input v-model="form.risk_rate" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Initial cost of capital-->
  <el-form-item label="Initial cost of capital" label-width="400px" prop="ini_cost_cap">
    <el-input v-model="form.ini_cost_cap" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!--Do you have employee options outstanding-->
  <el-form-item label="employee options outstanding?" label-width="400px">
    <el-switch v-model="form.employee" active-text="Yes" inactive-text="No"></el-switch>
  </el-form-item>

<!-------------------------------------------------------->
<!--Number of options outstanding-->
  <el-form-item label="Number of options outstanding" label-width="400px" prop="opt_outstanding">
    <el-input v-model="form.opt_outstanding" type="number"></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Average strike price-->
  <el-form-item label="Average strike price" label-width="400px" prop="strike_price">
    <el-input v-model="form.strike_price" type="number">
      <i slot="suffix">$</i></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Average maturity-->
  <el-form-item label="Average maturity" label-width="400px" prop="maturity">
    <el-input v-model="form.maturity" type="number"></el-input>
  </el-form-item>

<!-------------------------------------------------------->
<!--Standard deviation on stock price-->
  <el-form-item label="Standard deviation on stock price" label-width="400px"  prop="deviation_sto_price">
    <el-input v-model="form.deviation_sto_price" type="number">
      <i slot="suffix">%</i></el-input>
  </el-form-item>

  <!--el-form-item label="特殊资源">
    <el-radio-group v-model="form.resource">
      <el-radio label="线上品牌商赞助"></el-radio>
      <el-radio label="线下场地免费"></el-radio>
    </el-radio-group>
  </el-form-item-->

  <el-form-item>
    <el-button type="primary" @click="onSubmit('form')">Submit</el-button>
    <el-button @click="resetForm('form')">Reset</el-button>
  </el-form-item>

</el-form>


<!-------------------------------------------------------------->
<!-------------------------------------------------------------->
<!-------------------------------------------------------------->
<!-------------------------------------------------------------->
</div>

</template>

<script>
    export default{
        name: "Test",
        methods:{          
          onSubmit(form) {
            console.log(this.form)
            this.$refs[form].validate((valid) => {
            if (valid) {
              alert('submit!');
              } else {
              console.log('error submit!!');
              return false;
              }
            });
          },

          resetForm(form) {
            this.$refs[form].resetFields();
          },
        
          click(){
            console.log(this.form.name)
          },

          click2(){
            this.form.revenue1=this.form.revenue1*2
            console.log(this.form.revenue1*0.01)
          }
        },
    
    data() {
      return {
        left_form:'left',

        options1: [{
          value: 'United States',
          label: 'United States'
        }, {
          value: 'United Kingdom',
          label: 'United Kingdom'
        }, {
          value: 'Uruguay',
          label: 'Uruguay'
        }],
        country: '',

        options2: [{
          value: '1',
          label: '1'
        }, {
          value: 'United Kingdom',
          label: 'United Kingdom'
        }, {
          value: 'Uruguay',
          label: 'Uruguay'
        }],
        industry: '',

        form: {
          name: '',
          date1:'',
          date2:'',
          region: '',
          industry: '',
          R_and_D: false,
          cash_securities:'',
          type: [],
          resource: '',
          desc: '',
          revenue1:'',
          EBIT:'',
          Interest_expense: '',
          val_equity:'',
          val_debt:'',
          other_assets:'',
          minor_int:'',
          out_share:'',
          cur_price:'',

        },

        rules: {
          name: [
            { required: true, message: 'Please enter company name', trigger: 'blur' },
            { min: 3, max: 5, message: 'length is between 3-5', trigger: 'blur' }
          ],
          revenue1: [
            {required: true, message:'please enter something',  trigger: 'blur'},
            {type:'number', message:'please enter a number',  trigger: 'blur'}
          ],
          region: [
            { required: true, message: 'Please choose a region', trigger: 'blur' }
          ],
        }
      }
    }
      
}
</script>
