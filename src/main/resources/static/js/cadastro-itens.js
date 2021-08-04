function enviar()
{
	var produto = document.getElementById('produto');
	var quantidade = document.getElementById('quantidade');
	
	console.log(produto);
	const data = { codigo: 1, quantidade: 1 };
	
	fech('http://localhost:8080/pedidos/teste',{
		method: 'POST'
	})
	.then((ren) => alert(ren));  
	
	/*
const 	url = "/pedidos"
const body = { codigo: 1 , quantidade: 1}

fetch(url, {
  method: 'POST',
  body: JSON.stringify(body)
})
  .then((res) => res.json())
  .then((response) => console.log(response))*/
}
