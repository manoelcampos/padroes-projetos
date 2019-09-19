import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe para geração de instâncias de estudantes com dados aleatórios.
 * Lista de nomes obtidos no <a href="http://www.wjr.eti.br/nameGenerator/">Gerador de Nomes Aleatórios</a>.
 * @author Manoel Campos da Silva Filho
 */
public class StudentGenerator {
    private static final String NAMES = "Aarão Lins;Abel Magalhães;Abílio Diniz;Acacio Braz;Acacio Novaes;Adalberto Larangeira;Adalberto Rosmaninho;Adelino Azenha;Adelino Simões;Adelino Veloso;Adosindo Fróis;Adriano Bettencourt;Adélia Jorge;Adélia Madruga;Adérito Mederos;Afonso Távora;Aguinaldo Cardim;Aguinaldo Castellano;Aguinaldo Monjardim;Aida Fontoura;Aida Manso;Aida Outeiro;Aires Doutel;Ajuricaba Branco;Ajuricaba Medeiros;Alberta Moreno;Alberto Madeira;Alberto Villanueva;Albino Esteves;Alcides Amorín;Alcides Benevides;Alcides Sacadura;Alexandra Penteado;Alice Ipanema;Alicia Felgueira;Alicia Parente;Almeno Casqueira;Almeno Ramalho;Almerinda Carlos;Almor Severiano;Alvito Blanco;Alzira Goes;Alípio Carneiro;Amadeu Mainha;Amadeu Valim;Amandio Castilho;Amália Mata;Amália Mortágua;Amélia Cotegipe;Amélia Macieira;Amílcar Pajares;Amílcar Robalinho;Amílcar Velasco;Andreia Furquim;Andreoleto Ferraço;Angélica Guerrero;Angélico Lampreia;Angélico Maranhão;Angélico Souto Maior;Anhangüera Gallindo;Anhangüera Salgueiro;Aniana Cortés;Aniana Osório;Aniano Teles;Anind Sardina;Antonieta Pacheco;Antão Cascaes;Antão Quintais;Antão Sotomayor;António Salles;Antônia Cidreira;Antônia Ourique;Aníbal Cachão;Aníbal Fernández;Apoena Alencar;Apoena Linhares;Apoena Miguel;Araci Barreto;Araci Raminhos;Araci Álvez;Araribóia Moreno;Araribóia Mourão;Arcidres Borba;Armando Novaes;Armando Vilaverde;Arminda Figueiró;Armindo Alburquerque;Arnaldo Vasconcelos;Artur Borges;Asi Candeias;Asi Castel-Branco;Asi Monjardim;Astolfo Froes;Augusta Thamily;Aurora Martins;Aurélia Bulhões;Aurélio Anlicoara;Aurélio Bahía;Baltasar Fragoso;Baltasar Vega;Barnabé Valido;Bartolomeu Castanho;Bartolomeu Espargosa;Basilio Galante;Basilio Oliveira;Beatriz Hurtado;Belmira Barcelos;Belmira Cerqueira;Belmira Valverde;Benedita Negreiros;Benedito Lopes;Bento Guedez;Bento Villaça;Berengária Dinis;Berengário Coito;Bernardete Buenaventura;Bernardete Casado;Bernardete Malheiros;Bernardete Quintela;Bernardina Canhão;Bernardo Marcondes;Bibiana Queiroz;Boaventura Jácome;Boaventura Murici;Borrás Cortesão;Borrás Resende;Branco Damásio;Branco Lamego;Branco Mattozo;Brenda Sacadura;Brenda Vides;Bruna Estrela;Bruna Vilarim;Bruno Pimienta;Bruno Tigre;Brás Cavalheiro;Brás Estrada;Brígida Nieto;Bukake Picanço;Bukake Valverde;Burtira Guimaraens;Bárbara Cruz;Caetana Castelo Branco;Caetana Rebelo;Caetano Sanches;Caio Hidalgo;Calisto Ramires;Camila Bernárdez;Camila Cambezes;Camila Hidalgo;Camilo Botelho;Capitolina Gentil;Capitolino Monsanto;Capitolino Monte;Carina Ventura;Carla Cruz;Carlota Moita;Carmem Pérez;Carminda Robalinho;Carolina Benevides;Casimiro Curado;Catarina Bragança;Catarino Silva;Caubi Guimarães;Caubi Vidigal;Caubi Zambujal;Cauã Giménez;Cauê Campos;Cauê Castanheira;Cauê Valadares;Caím Flores;Celeste Araújo;Celeste Campos;Celeste Lemes;Celestino Jordán;Celestino Muñiz;Celina Raposo;Celina Rocha;Celso Caiapó;Celso Domínguez;Cesário Dorneles;Cesário Granjeiro;Cid Pacheco;Cidália Bezerril;Cidália Jaguariúna;Clara Lages;Clarisse Caldeira;Claudemira Dias;Cleiton Corvelo;Cleiton Gracia;Cleiton Rivas;Cleusa Piteira;Clotilde Camargo;Clotilde Magallanes;Cláudia Pirajá;Clóvis Ramalho;Collin Belchiorinho;Conceição Prado;Conrado Alcantara;Conrado Barra;Conrado González;Cora Araripe;Cora Prada;Corina Guzmán;Cosme Goes;Cosperranho Fernández;Cosperranho Gomes;Crispim Serpa;Cristiana Mendoza;Cristina Sabala;Cristóvão Buenaventura;Cássia Esparteiro;Cátia Magallanes;Cândida Espartero;Cândida Nazário;Cândido Azambuja;Célia Bivar;César Anhaia;Dalila Delgado;Dalila Mariz;Damião Ramos;Daniel Quintanilha;Daniela Varão;Davide Bernardes;Davide Santiago;Deise Pozas;Deise Quadros;Delfim Pedrozo;Delfina Medeiros;Denise Telles;Deolinda Ferreira;Deolinda Marinho;Deolindo Siqueira;Derli Leal;Diana Pardo;Diana Rebouças;Dina Raposo;Dinarte Cayubi;Dinis Marques;Dinis Serralheiro;Dino Amado;Dino Carvajal;Dino Freitas;Dino Mieiro;Diodete Bulhosa;Diodete Modesto;Diodete Pajares;Diodete Santarém;Diodete Soeiro;Diodete Ávila;Diogo Bethecourt;Diogo Pequeno;Diogo Torcuato;Diógenes Vega;Diógenes Vilas-Boas;Donata Bello;Donato Coello;Donato Lessa;Dora Damazio;Dora Gracia;Dora Soto;Dorindo Felgueiras;Dorindo Ochoa;Doroteia Barrios;Doroteia Dutra;Doroteia Figueiró;Duarte Rebello;Dulce Poças;Dália Mayor;Débora Amado;Délia Puerto;Délio Inácio;Délio Souto;Edgar Bezerra;Edgar Pardo;Edmundo Parente;Eduarda Novaes;Eduardo Caldera;Egas Becerril;Elba Belchiorinho;Elba Cardozo;Elba Nieves;Elia Cabeza de Vaca;Elia Salgado;Elias Hidalgo;Elisa Corvelo;Elisa Rosmaninho;Elisa Sarmiento;Elisabete Baptista;Eliseu Negrão;Eloi Blanco;Eloi Novais;Eloi Quintella;Elsa Avelar;Elsa Guilheiro;Elvira Estévez;Elvira Mederos;Eládio Aragão;Ema Leitão;Ema Veiga;Emanuel Marreiro;Emanuela Ramos;Emiliana Coello;Emiliano Regueira;Emídio Arouca;Emília Osório;Enilda Reguera;Epaminondas Farias;Epaminondas Gallindo;Epaminondas Quintanilla;Epifânia Macedo;Ermelinda Figueroa;Ermelinda Santiago;Ernesto Asunción;Ernesto Macedo;Esmeralda Guedella;Esmeralda Mascarenhas;Esmeralda Valle;Esperança Caballero;Esperança Gaspar;Esperança Madeira;Esperança Vieira;Estela Borba;Estela Cardin;Estela Coelho;Estela Perdigón;Ester Ribas;Estêvão Caldeira;Eudes Fonseca;Eugénia Jatobá;Eugénia Reyes;Eurico Franco;Eusébio Muniz;Eva Neres;Evandro Quadros;Evangelista Bacelar;Evangelista Ilha;Evangelista Lameirinhas;Evaristo Brasil;Ezequiel Pavía;Fabiana Amarante;Fabiana González;Fabrício Liberato;Fabíola Filgueiras;Faustino Zambujal;Feliciana Freiria;Felícia Almeida;Felícia Camello;Ferdinando Girão;Fernanda Nieves;Filena Villar;Filipa Guaraciaba;Filipe Estrada;Filipe Gouveia;Filomena Abranches;Filomena Guedelha;Filomena Neres;Filomena Vidal;Firmina Gil;Firmina Machado;Firmino Carvalheira;Flamínia Grangeia;Flamínia Sequera;Flor Alcaide;Flor Pimenta;Florbela Canadas;Floriano Alencar;Floriano Castelhano;Florinda Durán;Florinda Ulhoa;Floripes Bulhão;Florêncio Azenha;Florêncio Cascaes;Florêncio Vieira;Flávio Quintais;Francisca Damásio;Francisco Batista;Francisco Lages;Frederica Alencar;Frederica Cascaes;Frederico Bugallo;Frutuoso Beserra;Fulvio Girã;Fulvio Paiva;Fábia Paraguaçu;Fábio Meireles;Fábio Quinterno;Fátima Leiria;Félix Belém;Félix Cavalheiro;Gabriel Peres;Gabriela Pais;Galindo Acatauaçu;Galindo Beltrão;Galindo Pedrozo;Gastão Brión;Gastão Regalado;Gaudêncio Alves;Gedeão Rosa;Genoveva Reino;Genoveva Velázquez;Geraldo Moniz;Geraldo Simas;Gerardo Cysneiros;Gerardo Cysneiros;Gerardo Sacramento;Germano Flores;Germano Lagoa;Gerson Caetano;Gerson Lameira;Gertrudes Figueiroa;Gertrudes Lage;Gerusa Cayado;Gerusa Moreno;Gerusa Regalado;Gilberto Ferrão;Gilda Castanheira;Gina Corrêa;Gina Pequeno;Ginéculo Cachoeira;Girão Gomide;Gisela Monte;Gisela Parente;Gisela Velázquez;Gláuber Becerril;Gláucia Guarabira;Gláucio Sampaio;Glória Aveiro;Godinho ou Godim Guedez;Gonçalo Campos;Graciano Franco;Greice Sampaio;Guadalupe Cardim;Guadalupe Lira;Guadalupe Montenegro;Guadalupe Verissimo;Gualdim Resende;Guaraci Ventura;Gueda Barrios;Gueda Leitão;Gueda Peralta;Gui Casquero;Gui Dinis;Guido Pari;Guido Quirino;Guido Regueira;Guilhermina Asunción;Guilhermina Feitosa;Gávio Rico;Heitor Faia;Heloísa Jordão;Henrique Travassos;Herberto Beltrán;Herculano Sobreira;Hermano Gaspar;Hermenegildo Salguero;Hermesinda Becerra;Hermesinda Caiapó;Hermesinda Horta;Hermígio Sanches;Hernâni Bacelar;Hernâni Carrasqueira;Hernâni Ginjeira;Hernâni Ríos;Higino Caniça;Hipólito Cruz;Honório Grilo;Honório Vides;Hugo Bicudo;Hugo Rico;Hugo Sardinha;Humberto Betancour;Humberto Braz;Humberto Larangeira;Hélder Beiriz;Hélia Athayde;Hélia Maranhão;Iara Laranjeira;Iberê Piteira;Ibijara Garcés;Ifigénia Eiró;Ifigénia Hurtado;Ildefonso Jordán;Ilduara Leça;Ilma Beça;Ilma Eanes;Ilídio Gaspar;Ilídio Lacerda;Ilídio Lóio;Ilídio Rodovalho;Inaiá Fidalgo;Inácio Mederos;Inês Mangueira;Iolanda Camilo;Iraci Castellano;Iraci Portela;Iraci Varella;Irani Castelbranco;Irene Freitas;Isaac, Isaque Bogado;Isaura Rolim;Isidro Menna;Isilda Estrella;Isilda Prada;Ismael Alcántara;Itiberê Granjeia;Iva Pinho;Iva Talhão;Ivete Silvestre;Jaci Amado;Jaci Linhares;Jacinta Bezerra;Jacir Mota;Jacira Anjos;Jacira Galván;Jadir Valiente;Jaime Matos;Jaime Monteiro;Janaína Trinidad;Jandaíra Fortunato;Jandira Melo;Jerónimo, Jerônimo Freiria;Joaquim Simões;Joaquina Filipe;Joaquina Sarmiento;Joel Beiriz;Jonas Varella;Jordão Póvoas;Jorge Rufino;Jorge Álvaro;Jorgina Villela;Josefa Ipanema;Josefa Loio;Josefa Vides;Josias Villas Bôas;João Arruda;João Landim;Judas Cachoeira;Judas Montenegro;Julieta Muñiz;Julieta Villena;Justino Reino;Justino Robalo;Jutaí Thamily;Juçara Figueira;Juçara Liberato;Jéssica Caldera;Lara Mendoça;Lara Seabra;Lavínia Bethecourt;Lavínia Novalles;Leandro Castilhos;Leandro Ribeiro;Leonardo Juruna;Leonardo Mangueira;Leonardo Taveira;Leonel Gil;Leonilde Baptista;Leonilde Taborda;Leopoldina Mont'Alverne;Leopoldina Torquato;Leopoldo Frota;Leopoldo Reguera;Letícia Casqueira;Letícia Téllez;Levindo Cysneiros;Leónidas Lemes;Liedson Faria;Liedson Águeda;Liliana Barcellos;Liliana Osorio;Liliana Tomé;Lineu Horta;Lineu Tabalipa;Lino Fortunato;Lopo Candal;Lopo Quintella;Lourenço Guaraciaba;Lua Marroquim;Luana Batista;Luana Butantã;Luciana Batista;Luciana Seixas;Luciano Brandán;Lucinda Bezerra;Lucrécia Tabares;Lucília Jardim;Lucília Ximenes;Lucílio Canadas;Lucílio Salguero;Ludovico Alcantara;Luize Asunción;Luize Telles;Luize Verissimo;Luzia Guedez;Luís Cintra;Luís Coelho;Luísa Toledo;Léia Mena;Lídia Afonso;Lídia Barrocas;Lídia Novais;Lígia Sardinha;Lígia Veiga;Lília Abreu;Lúcia Galván;Lúcia Távora;Madalena Núñez;Madalena Valgueiro;Magali Bulhosa;Magda Jordão;Maiara Nieto;Maiara Tristão;Mamede Belo;Mamede Braga;Mamede García;Manuela Nieves;Marcelo Escobar;Marco Hurtado;Marco Seixas;Marco Valerio;Marcos Asunción;Margarida Figueiredo;Margarida Jesus;Maria Liberato;Mariana Cayado;Mariana Padilla;Mariana Rabello;Mariano Casquero;Mariano Cisneiros;Marilda Batata;Marilda Malheiro;Marina Barros;Marisa Brião;Marisa Hidalgo;Marta Dantas;Marta Lameiras;Martim Ipiranga;Martim Simón;Martinho Seixas;Marília Rego;Matias Carrasqueira;Maximiliano Rodríguez;Maíra Gil;Mbicy Cavadas;Mbicy Suárez;Melissa Espartero;Melissa Feijó;Melissa Pitanga;Mem Mesquita;Mem Portugal;Micael Melo;Micaela Cisneros;Miguel Cysneiros;Mileide Cayado;Mileide Javier;Mileide Pino;Mileide Rodovalho;Milena Dutra;Milu Lameirinhas;Miriam Domingos;Miriam Guimaraens;Miriam Javier;Miru Barros;Miru Braz;Miru Leitão;Miru Pinto;Moaci Antunes;Moaci Nogueira;Moema Baranda;Moisés Bento;Moisés Fróis;Morgana Barros;Murici Fagundes;Murilo Cardoso;Murilo Freiria;Márcio Bulhão;Máxima Canário;Mónica Briones;Mónica Fiães;Mônica   Machado;Mônica   Álvarez;Natacha Palhares;Natividade Bonilla;Natividade Meneses;Natália Figueira;Natália Filgueiras;Natália Rua;Nazaré Guimarães;Nestor Albernaz;Neuza Bahía;Neuza Vilas-Boas;Nicolas Beltrán;Nicolau Guará;Nicolau Lucas;Nivaldo Ribas;Nivaldo Vasconcelos;Noel Cisneros;Noel Jordão;Noel Louzada;Noel Vicario;Norberto Cidreira;Noé Branco;Noé Chaves;Noé Freiria;Noé Mattos;Noé Pires;Noêmia   Goulart;Nádia Flores;Nádia Granjeiro;Nídia Jiménez;Ofélia Cisneiros;Ofélia Tavares;Olavo Palmeira;Olga Dias;Olga Pais;Oliveira Belchiorinho;Olívio Paiva;Olívio Vasques;Ondina Borges;Ondina Fidalgo;Ondina Varanda;Ordonho Bugalho;Ordonho Delgado;Oriana Vaz;Oscar   Cavadas;Oscar   Nunes;Oscar   Paiva;Osvaldo Rosmaninho;Otávio Valladares;Otília Beltrán;Ovídio Curvelo;Ovídio Jardim;Ovídio Méndez;Palmiro Barcelos;Palmiro Barroso;Palmiro Bethecourt;Palmiro Bivar;Palo Pestana;Pandora Toledo;Pandora Valle;Paraguaçu Baptista;Paraguaçu Tamoio;Pascoal Luz;Patrícia Bensaúde;Patrícia Eanes;Paula Vasconcelos;Paulino Espargosa;Paulo Capucho;Paulo Gómez;Penélope Hilário;Penélope Quintella;Piedade Carlos;Piedade Collaço;Piedade Gil;Plínio Alancastre;Plínio Lameiras;Poliana Freiria;Poliana Jiménez;Polibe Faria;Políbio Goes;Potira Monte;Potira Novais;Potira Queirós;Priscila Calheiros;Priscila Camello;Priscila Motta;Querubim Domínguez;Quintiliano Aranha;Quintiliano Barata;Quintilien Manso;Quintilien Noronha;Quintilien Peña;Quintino Silveira;Quirina Alcântara;Quirina Balsemão;Quirina Borba;Quirina Corvelo;Quirino Belo;Quévin Tabares;Raimundo Bahía;Raimundo Mourão;Ramiro Zagallo;Raquel Barateiro;Raquel Capanema;Raquel Peña;Raquel Sánchez;Raul Sardina;Rebeca Coitinho;Rebeca Negreiros;Regina Briones;Regina Caniça;Remo Viera;Renan Colaço;Renan Vásquez;Renata Quintão;Renato Tabalipa;Ricardina Nóbrega;Ricardo Hilário;Rita Ataíde;Roberto Vázquez;Rogério Hernández;Rogério Tomé;Romano Grillo;Romano Mieiro;Romano Pádua;Ronaldo Rosmaninho;Roquita Belchior;Roquita Javier;Rosa Bivar;Rosa Delgado;Rosalina Guedez;Rosalina Melgaço;Rosalina Sobreira;Rosalinda Albuquerque;Rosalinda Bonilla;Rosaura Negrão;Rosaura Perdigão;Roseli Abranches;Roseli Garcez;Rosário Bensaúde;Rosário Briones;Rosário Cardim;Rosário Varejão;Rubim Sarabia;Rudá Souto;Rufus Alencar;Rufus Lemes;Rui Filgueiras;Rute Araripe;Rute Coitinho;Rute López;Rômulo   Carvalhaes;Rúben Lousado;Rúben Puerto;Sabina Ataí;Sabino Anhaia;Sabino Curado;Sabino Quirós;Sabrina Meira;Salomão Beltrán;Salomé Cardin;Salvador Valério;Salvina Colares;Samuel Valentim;Samuel Xavier;Sancha Guaraciaba;Sandoval Trinidad;Sandra Camacho;Sandra Chamusca;Sandro Avelar;Sara Valverde;Sebastiana Belmonte;Sebastiana Domínguez;Sebastiana Pederneiras;Sebastião Cidreira;Sebastião Passos;Serafim Curvelo;Serafim Villalobos;Sidónio Alcántara;Sidônio   Maciel;Silvano Souto Maior;Silvério Guimarães;Silvério Penteado;Silvério Salomón;Simone Angelim;Siquenique Marmou;Siquenique Peçanha;Sofia Temes;Solano Brasil;Sonás Candal;Suniário Abasto;Suniário Brasil;Suniário Clementino;Suniário Colares;Susana Canela;Susana Girão;Sérgio Bastos;Sérgio Lagoa;Sérgio Rivas;Sílvia Piñero;Sônia ou Sonia   Porciúncula;Sônia ou Sonia   Vigário;Tadeu Vilas-Boas;Tainá Salles;Tainá Sant'Anna;Tairine Ornellas;Tatiana Valadares;Taíssa Brião;Telma Aranha;Telma Barcelos;Telma Palmeira;Telma Quirós;Telma Tristán;Telo Bahía;Teodora Bulhosa;Teodorico Corte-Real;Teodorico Maranhão;Teodorico Novalles;Teodorico Sotomayor;Teodoro Peixoto;Teresa Borges;Tibúrcio Meneses;Timóteo Menezes;Tobias Ornellas;Tomás Castelhano;Tomé Mascareñas;Tomé Rivas;Tristão Foquiço;Tristão Póvoas;Tânia Damazio;Tânia Mederos;Tânia Monjardim;Ubajara Lage;Ubajara Madureira;Ubajara Mourato;Ubirajara Teves;Ubiratã Abranches;Ubiratã Cordero;Ubiratã Moreyra;Udo Bensaúde;Ulisses Medina;Umbelina Carijó;Valdeci Cordeiro;Valdeci Madruga;Valdemar Cachão;Valdemar Festas;Valentim Guedella;Valentina Lóio;Valmor Covelhã;Valmor Quintas;Valmor Quiroga;Valéria Chamusca;Vanda Carvalheira;Vanda Osorio;Vanda Sabrosa;Vanessa Alancastro;Vanessa Caldeira;Vanessa Gusmão;Vanessa Landim;Vanessa Pessoa;Vasco Fróis;Veridiano Bautista;Veríssimo Caniça;Veríssimo Valladares;Vicente Covinha;Virgínia Coutinho;Viridiano Castelo Branco;Viridiano Lameira;Viridiano Sotomayor;Vitória Garcia de Gondim;Viviana Macena;Viviana Ulloa;Vítor ou Victor Abranches;Vítor ou Victor Valiente;Xavier Cordeiro;Xerxes Covinha;Xisto Furtado;Xisto Salomón;Xénia Siebra;Xênia   Pozas;Zacarias Bahía;Zara Carneiro;Zara Gomide;Zidane Jardim;Zilda Caldera;Zilda Souto;Zita Lucena;Zita Salomón;Zita Severiano;Zoe Moura;Zoe Valladares;Zoraide Gago;Zoraide Jácome;Zoraide Quintais;Zoraide Regalado;Zoraide Zalazar;Zubaida Marques;Zuriel Maior;Álvaro Vidal;Átila Marreiro;Ângela Alancastre;Ângela Caldas;Ângela Enríquez;Ângela Gutiérrez;Ângela Madruga;Ângelo Lameira;Élvio Freire;Énia Paes;Érica Feitosa;Érica Torrado;Íris Azenha;Íris Casado;Ítala Jatobá;Ítala Mirandela;Ítala Xavier;Ítalo Valiente;Óscar Corvelo;Úrsula Pimenta;Úrsula Vilariça";

    /**
     * Vetor contendo uma lista de nomes a serem sorteados aleatoriamente para
     * criar um aluno.
     */
    private static final String[] NAMES_ARRAY = NAMES.split(";");

    /**
     * Lista de cursos em que os alunos serão aleatoriamente matriculados.
     */
    private static final Course[] COURSES = {
            new Course(1, "Sistemas para Internet", 6),
            new Course(2, "Engenharia Elétrica", 10),
            new Course(3, "Engenharia Civil", 10),
            new Course(4, "Matemática", 8),
            new Course(5, "Educação Física", 8),
            new Course(6, "Gestão Pública", 6)
    };

    /**
     * Gerador de números aleatórios.
     */
    private static final Random rand = new Random();

    /**
     * Gera uma lista aleatória de alunos.
     * @param total total de alunos que deseja gerar
     * @return a lista de alunos gerados
     */
    public static List<Student> generate(final int total){
        System.out.printf("Gerando %d alunos!\n", total);
        List<Student> list = new ArrayList<>(total);
        for (int i = 1; i <= total; i++) {
            list.add(new Student(i, randName(), randGender(), randScore(), randGradYear(), randCourse()));
        }

        return list;
    }

    /**
     * Gera um nome aleatório.
     * @return
     */
    private static String randName(){
        return NAMES_ARRAY[randInt(NAMES_ARRAY.length)];
    }

    /**
     * Gera um sexo aleatório.
     * @return
     */
    private static char randGender(){
        return rand.nextBoolean() ? 'M' : 'F';
    }

    /**
     * Gera uma nota aleatória para um aluno.
     * @return
     */
    private static double randScore(){
        return randDouble(10);
    }

    /**
     * Gera um ano de graduação aleatório para um aluno.
     * @return
     */
    private static int randGradYear(){
        return randInt(40)+1980;
    }

    /**
     * Escolhe um curso aleatório para um aluno.
     * @return
     */
    private static Course randCourse(){
        return COURSES[randInt(COURSES.length)];
    }

    /**
     * Gera um número inteiro aleatório entre [0 e max[.
     * @return
     */
    private static int randInt(final int max){
        return Math.abs(rand.nextInt())%max;
    }

    /**
     * Gera um número real aleatório entre [0 e max[.
     * @return
     */
    private static double randDouble(final double max){
        return Math.abs(rand.nextDouble())*max;
    }
}
