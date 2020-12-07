const reader = require('line-reader');

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
                          cpfCliente = "", valor = 0, multa = 0, juros = 0, 
                          agencia = "", contaBancaria = ""})
{
    this.id = id;
    this.codBanco = codBanco;
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
    this.cpfCliente = cpfCliente;
    this.valor = valor;
    this.multa = multa;
    this.juros = juros;
    this.agencia = agencia;
    this.contaBancaria = contaBancaria;
};

/**
 * Retorna um objeto Boleto do Banco do Brasil,
 * cujos dados são obtidos de um array gerado
 * a partir de uma linha do arquivo de retorno.
 * @param arrayLinhaArquivo Array gerado a partir da divisão dos campos
 *                          de uma linha lida de um arquivo de retorno de boletos.
 * @return um objeto {@link Boleto} contendo os dados lidos da linha do arquivo
 */
const leituraRetornoBancoBrasil = (arrayLinhaArquivo) => {
    return new Boleto({
        id: arrayLinhaArquivo[0],
        codBanco: arrayLinhaArquivo[1],
        dataVencimento: arrayLinhaArquivo[2],
        dataPagamento: arrayLinhaArquivo[3],
        cpfCliente: arrayLinhaArquivo[4],
        valor: arrayLinhaArquivo[5],
        multa: arrayLinhaArquivo[6],
        juros: arrayLinhaArquivo[7]
    });
};

/**
 * Retorna um objeto Boleto do Bradesco,
 * cujos dados são obtidos de um array gerado
 * a partir de uma linha do arquivo de retorno.
 * @param arrayLinhaArquivo Array gerado a partir da divisão dos campos
 *                          de uma linha lida de um arquivo de retorno de boletos.
 * @return um objeto {@link Boleto} contendo os dados lidos da linha do arquivo
 */
const leituraRetornoBradesco = (arrayLinhaArquivo) => {
    return new Boleto({
        id: arrayLinhaArquivo[0],
        codBanco: arrayLinhaArquivo[1],
        agencia: arrayLinhaArquivo[2],
        contaBancaria: arrayLinhaArquivo[3],
        dataVencimento: arrayLinhaArquivo[4],
        dataPagamento: arrayLinhaArquivo[5],
        cpfCliente: arrayLinhaArquivo[6],
        valor: arrayLinhaArquivo[7],
        multa: arrayLinhaArquivo[8],
        juros: arrayLinhaArquivo[9]
    });
};

/**
 * "Classe" estrategista que utilizará as estratégias para
 * leitura de arquivos de retorno.
 */
const ProcessarBoletos = function(leituraRetorno){
    this.leituraRetorno = leituraRetorno;

    /**
     * Template method que define a estrutura para leitura de 
     * qualquer arquivo de boleto.
     * Um dos passos de tal algoritmo é definido por
     * uma função leituraRetorno externa, que deve
     * ser passada no construtor da "classe" ProcessarBoletos.
     * Com isto, todo o código que ficaria duplicado
     * em cada uma dessas funções para cada um dos diferentes bancos,
     * fica centralizado aqui.
     */
    this.lerArquivo = (nomeArquivo) => {
        reader.eachLine(nomeArquivo, line => {
            const array = line.split(";");
            const boleto = this.leituraRetorno(array);
            console.log(boleto);
            console.log("");
        });
    };

    this.processar = (nomeArquivo) => {
        console.log("\nIniciando processamento do arquivo " + nomeArquivo);
        this.lerArquivo(nomeArquivo);
    };
};


const processador = new ProcessarBoletos(leituraRetornoBancoBrasil);
processador.processar("banco-brasil-1.csv");

//processador.leituraRetorno = leituraRetornoBradesco;
//processador.processar("bradesco-1.csv");