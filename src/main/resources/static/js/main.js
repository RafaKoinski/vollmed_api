const form = document.getElementById("form_medico");
form.addEventListener("submit", evento => novoMedico(evento));

async function novoMedico(evento) {

    evento.preventDefault(); // Impede o envio padrão do formulário


    const nome = document.getElementById("nome").value,
    const email = document.querySelector('input[name="email"]').value,
    const telefone = document.getElementById("telefone").value,
    const crm = document.getElementById("crm").value,
    const especialidade = document.getElementById("especialidade").value,
    const logradouro = document.getElementById("logradouro").value,
    const bairro = document.getElementById("bairro").value,
    const cep = document.getElementById("cep").value,
    const cidade = document.getElementById("cidade").value,
    const uf = document.getElementById("uf").value,
    const num = document.getElementById("numero").value,
    const complemento = document.getElementById("complemento").value,

    // Envie os dados como JSON
    await enviarDadosComoJSON(nome, email, telefone, crm, especialidade, logradouro, bairro, cep, cidade, uf, num, complemento);

    window.location.href = "../templates/envio-concluido.html";



};

async function enviarDadosComoJSON(nome, email, telefone, crm, especialidade, logradouro, bairro, cep, cidade, uf, num, complemento) {
    const resultado = await fetch('http://localhost:8080/medicos', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            nome: nome,
            email: email,
            telefone: telefone,
            crm: crm,
            especialidade: especialidade,
            endereco: {
                logradouro: logradouro,
                bairro: bairro,
                cep: cep,
                cidade: cidade,
                uf: uf,
                num: num,
                complemento: complemento
                }
        })

    });
    const conexao = await resultado.json();
    return conexao;
}

