const reader = require('line-reader');

/*
 * Implementa a leitura de arquivos de retorno de boletos bancários utilizando
 * o padrão Strategy.
 * Este é apenas um projeto de exemplo e inclui todas as classes em um único
 * arquivo apenas para facilitar a leitura.
 */

/**
 * "Classe" que representa um boleto bancário.
 * Não é utilizado o recurso de class do ES6 devido 
 * a problemas com arrow functions.
 * Assim, a "classe" é implementada por
 * meio do recurso de Constructor Functions.
 * Assim, a "classe" é nada mais que uma função,
 * mas Constructor Functions não podem ser escritas
 * usando Arrow Functions, apenas da forma tradicional.
 * 
 * Alguns dos problemas relacionados à "classes"
 * em Javascript podem ser vistos em 
 * https://everyday.codes/javascript/please-stop-using-classes-in-javascript/
 */
const Boleto = function({ id = 0, codBanco = "000", dataVencimento = "", dataPagamento = "",
                  cpfCliente = "", valor = 0, multa = 0, juros = 0, contaBancaria = ""})
{
    this.id = id;
    this.codBanco = codBanco;
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
    this.cpfCliente = cpfCliente;
    this.valor = valor;
    this.multa = multa;
    this.juros = juros;
    this.contaBancaria = contaBancaria;
};

/**
 * Define a estratégia para leitura de arquivos do Banco do Brasil.
 * Em JavaScript, não precisamos de fato criar uma classe/objeto para isto,
 * basta criar uma função que será passada para a classe estrategista,
 * Desta forma, podemos trocar a implementação da função
 * que realizar a leitura do arquivo a qualquer momento.
 * 
 * Neste caso, como esta não é uma Constructor Function,
 * podemos usar a sintaxe de Arrow Functions sem problemas (que é abreviada).
 */
const leituraRetornoBancoBrasil = (nomeArquivo) => {
    console.log("Processando arquivo do Banco do Brasil: " + nomeArquivo + "\n");
    reader.eachLine(nomeArquivo, line => {
        const array = line.split(";");
        const boleto = new Boleto({
            id: array[0],
            codBanco: array[1],
            dataVencimento: array[2],
            dataPagamento: array[3],
            cpfCliente: array[4],
            valor: array[5],
            multa: array[6],
            juros: array[7]
        });

        console.log(boleto);
        console.log("");
    });    
};

const leituraRetornoBradesco = (nomeArquivo) => {
    console.log("Processando arquivo do Bradesco: " + nomeArquivo);
    console.log("Falta implementar função do Bradesco");
};

/**
 * "Classe" estrategista que utilizará as estratégias para
 * leitura de arquivos de retorno.
 */
const ProcessarBoletos = function(leituraRetorno){
    this.leituraRetorno = leituraRetorno;
    this.processar = (nomeArquivo) => {
        console.log("\nIniciando processamento do arquivo " + nomeArquivo);
        
        this.leituraRetorno(nomeArquivo);
    };
};


const processador = new ProcessarBoletos(leituraRetornoBancoBrasil);
processador.processar("banco-brasil-1.csv");

//processador.leituraRetorno = leituraRetornoBradesco;
//processador.processar("bradesco-1.csv");