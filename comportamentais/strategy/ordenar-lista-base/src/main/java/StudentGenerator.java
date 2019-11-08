import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe para geração de instâncias de estudantes com dados aleatórios.
 * Lista de nomes obtidos no <a href="http://www.wjr.eti.br/nameGenerator/">Gerador de Nomes Aleatórios</a>.
 * @author Manoel Campos da Silva Filho
 */
public class StudentGenerator {
    private static final String MEN = "Aarão Lins;Abel Magalhães;Abílio Diniz;Acacio Braz;Acacio Novaes;Adalberto Larangeira;Adalberto Rosmaninho;Adelino Azenha;Adelino Simões;Adelino Veloso;Adosindo Fróis;Adriano Bettencourt;Adérito Mederos;Afonso Távora;Aguinaldo Cardim;Aguinaldo Castellano;Aguinaldo Monjardim;Aires Doutel;Ajuricaba Branco;Ajuricaba Medeiros;Alberto Madeira;Alberto Villanueva;Albino Esteves;Alcides Amorín;Alcides Benevides;Alcides Sacadura;Almeno Casqueira;Almeno Ramalho;Almor Severiano;Alvito Blanco;Alípio Carneiro;Amadeu Mainha;Amadeu Valim;Amandio Castilho;Amílcar Pajares;Amílcar Robalinho;Amílcar Velasco;Andreoleto Ferraço;Angélico Lampreia;Angélico Maranhão;Angélico Souto Maior;Anhangüera Gallindo;Anhangüera Salgueiro;Aniano Teles;Anind Sardina;Antão Cascaes;Antão Quintais;Antão Sotomayor;António Salles;Aníbal Cachão;Aníbal Fernández;Araribóia Moreno;Araribóia Mourão;Arcidres Borba;Armando Novaes;Armando Vilaverde;Armindo Alburquerque;Arnaldo Vasconcelos;Artur Borges;Asi Candeias;Asi Castel-Branco;Asi Monjardim;Astolfo Froes;Aurora Martins;Aurélio Anlicoara;Aurélio Bahía;Baltasar Fragoso;Baltasar Vega;Barnabé Valido;Bartolomeu Castanho;Bartolomeu Espargosa;Basilio Galante;Basilio Oliveira;Benedito Lopes;Bento Guedez;Bento Villaça;Berengário Coito;Bernardo Marcondes;Boaventura Jácome;Boaventura Murici;Borrás Cortesão;Borrás Resende;Branco Damásio;Branco Lamego;Branco Mattozo;Bruno Pimienta;Bruno Tigre;Brás Cavalheiro;Brás Estrada;Bukake Picanço;Bukake Valverde;Caetano Sanches;Caio Hidalgo;Calisto Ramires;Camilo Botelho;Capitolina Gentil;Capitolino Monsanto;Capitolino Monte;Casimiro Curado;Catarino Silva;Caubi Guimarães;Caubi Vidigal;Caubi Zambujal;Cauã Giménez;Cauê Campos;Cauê Castanheira;Cauê Valadares;Caím Flores;Celestino Jordán;Celestino Muñiz;Celso Caiapó;Celso Domínguez;Cesário Dorneles;Cesário Granjeiro;Cid Pacheco;Cleiton Corvelo;Cleiton Gracia;Cleiton Rivas;Clóvis Ramalho;Collin Belchiorinho;Conrado Alcantara;Conrado Barra;Conrado González;Cosme Goes;Cosperranho Fernández;Cosperranho Gomes;Crispim Serpa;Cristóvão Buenaventura;Cândido Azambuja;Célia Bivar;César Anhaia;Damião Ramos;Daniel Quintanilha;Davide Bernardes;Davide Santiago;Delfim Pedrozo;Deolindo Siqueira;Derli Leal;Dinis Marques;Dinis Serralheiro;Dino Amado;Dino Carvajal;Dino Freitas;Dino Mieiro;Diogo Bethecourt;Diogo Pequeno;Diogo Torcuato;Diógenes Vega;Diógenes Vilas-Boas;Donato Coello;Donato Lessa;Dorindo Felgueiras;Dorindo Ochoa;Duarte Rebello;Délio Inácio;Délio Souto;Edgar Bezerra;Edgar Pardo;Edmundo Parente;Eduardo Caldera;Egas Becerril;Elias Hidalgo;Eliseu Negrão;Eloi Blanco;Eloi Novais;Eloi Quintella;Eládio Aragão;Emanuel Marreiro;Emiliano Regueira;Emídio Arouca;Epaminondas Farias;Epaminondas Gallindo;Epaminondas Quintanilla;Ernesto Asunción;Ernesto Macedo;Estêvão Caldeira;Eudes Fonseca;Eurico Franco;Eusébio Muniz;Evandro Quadros;Evaristo Brasil;Ezequiel Pavía;Fabrício Liberato;Fabíola Filgueiras;Faustino Zambujal;Ferdinando Girão;Filipe Estrada;Filipe Gouveia;Firmino Carvalheira;Floriano Alencar;Floriano Castelhano;Floripes Bulhão;Florêncio Azenha;Florêncio Cascaes;Florêncio Vieira;Flávio Quintais;Francisco Batista;Francisco Lages;Frederico Bugallo;Frutuoso Beserra;Fulvio Girã;Fulvio Paiva;Fábio Meireles;Fábio Quinterno;Félix Belém;Félix Cavalheiro;Gabriel Peres;Galindo Acatauaçu;Galindo Beltrão;Galindo Pedrozo;Gastão Brión;Gastão Regalado;Gaudêncio Alves;Gedeão Rosa;Geraldo Moniz;Geraldo Simas;Gerardo Cysneiros;Gerardo Cysneiros;Gerardo Sacramento;Germano Flores;Germano Lagoa;Gerson Caetano;Gerson Lameira;Gilberto Ferrão;Ginéculo Cachoeira;Girão Gomide;Gláuber Becerril;Gláucio Sampaio;Glória Aveiro;Godinho ou Godim Guedez;Gonçalo Campos;Graciano Franco;Gualdim Resende;Gui Casquero;Gui Dinis;Guido Pari;Guido Quirino;Guido Regueira;Gávio Rico;Heitor Faia;Henrique Travassos;Herberto Beltrán;Herculano Sobreira;Hermano Gaspar;Hermenegildo Salguero;Hermígio Sanches;Hernâni Bacelar;Hernâni Carrasqueira;Hernâni Ginjeira;Hernâni Ríos;Higino Caniça;Hipólito Cruz;Honório Grilo;Honório Vides;Hugo Bicudo;Hugo Rico;Hugo Sardinha;Humberto Betancour;Humberto Braz;Humberto Larangeira;Hélder Beiriz;Ibijara Garcés;Ildefonso Jordán;Ilídio Gaspar;Ilídio Lacerda;Ilídio Lóio;Ilídio Rodovalho;Inácio Mederos;Isaque Bogado;Isidro Menna;Ismael Alcántara;Itiberê Granjeia;Jacir Mota;Jadir Valiente;Jaime Matos;Jaime Monteiro;Jerônimo Freiria;Joaquim Simões;Joel Beiriz;Jonas Varella;Jordão Póvoas;Jorge Rufino;Jorge Álvaro;Josias Villas Bôas;João Arruda;João Landim;Judas Cachoeira;Judas Montenegro;Justino Reino;Justino Robalo;Jutaí Thamily;Leandro Castilhos;Leandro Ribeiro;Leonardo Juruna;Leonardo Mangueira;Leonardo Taveira;Leonel Gil;Leopoldo Frota;Leopoldo Reguera;Levindo Cysneiros;Leónidas Lemes;Liedson Faria;Liedson Águeda;Lineu Horta;Lineu Tabalipa;Lino Fortunato;Lopo Candal;Lopo Quintella;Lourenço Guaraciaba;Luciano Brandán;Lucinda Bezerra;Lucílio Canadas;Lucílio Salguero;Ludovico Alcantara;Luís Cintra;Luís Coelho;Mamede Belo;Mamede Braga;Mamede García;Marcelo Escobar;Marco Hurtado;Marco Seixas;Marco Valerio;Marcos Asunción;Mariano Casquero;Mariano Cisneiros;Martim Ipiranga;Martim Simón;Martinho Seixas;Matias Carrasqueira;Maximiliano Rodríguez;Micael Melo;Miguel Cysneiros;Moaci Antunes;Moaci Nogueira;Moisés Bento;Moisés Fróis;Murici Fagundes;Murilo Cardoso;Murilo Freiria;Márcio Bulhão;Nestor Albernaz;Nicolas Beltrán;Nicolau Guará;Nicolau Lucas;Nivaldo Ribas;Nivaldo Vasconcelos;Noel Cisneros;Noel Jordão;Noel Louzada;Noel Vicario;Norberto Cidreira;Noé Branco;Noé Chaves;Noé Freiria;Noé Mattos;Noé Pires;Olavo Palmeira;Olívio Paiva;Olívio Vasques;Ordonho Bugalho;Ordonho Delgado;Oscar Cavadas;Oscar Nunes;Oscar Paiva;Osvaldo Rosmaninho;Otávio Valladares;Ovídio Curvelo;Ovídio Jardim;Ovídio Méndez;Palmiro Barcelos;Palmiro Barroso;Palmiro Bethecourt;Palmiro Bivar;Palo Pestana;Paraguaçu Baptista;Paraguaçu Tamoio;Pascoal Luz;Paulino Espargosa;Paulo Capucho;Paulo Gómez;Plínio Alancastre;Plínio Lameiras;Políbio Goes;Querubim Domínguez;Quintiliano Aranha;Quintiliano Barata;Quintilien Manso;Quintilien Noronha;Quintilien Peña;Quintino Silveira;Quirino Belo;Quévin Tabares;Raimundo Bahía;Raimundo Mourão;Ramiro Zagallo;Raul Sardina;Remo Viera;Renan Colaço;Renan Vásquez;Renato Tabalipa;Ricardo Hilário;Roberto Vázquez;Rogério Hernández;Rogério Tomé;Romano Grillo;Romano Mieiro;Romano Pádua;Ronaldo Rosmaninho;Rosário Bensaúde;Rosário Briones;Rosário Cardim;Rosário Varejão;Rubim Sarabia;Rudá Souto;Rufus Alencar;Rufus Lemes;Rui Filgueiras;Rômulo Carvalhaes;Rúben Lousado;Rúben Puerto;Sabino Anhaia;Sabino Curado;Sabino Quirós;Salomão Beltrán;Salomé Cardin;Salvador Valério;Samuel Valentim;Samuel Xavier;Sandoval Trinidad;Sandro Avelar;Sebastião Cidreira;Sebastião Passos;Serafim Curvelo;Serafim Villalobos;Sidónio Alcántara;Sidônio Maciel;Silvano Souto Maior;Silvério Guimarães;Silvério Penteado;Silvério Salomón;Solano Brasil;Sonás Candal;Suniário Abasto;Suniário Brasil;Suniário Clementino;Suniário Colares;Sérgio Bastos;Sérgio Lagoa;Sérgio Rivas;Sílvia Piñero;Tadeu Vilas-Boas;Telo Bahía;Teodorico Corte-Real;Teodorico Maranhão;Teodorico Novalles;Teodorico Sotomayor;Teodoro Peixoto;Tibúrcio Meneses;Timóteo Menezes;Tobias Ornellas;Tomás Castelhano;Tomé Mascareñas;Tomé Rivas;Tristão Foquiço;Tristão Póvoas;Ubajara Lage;Ubajara Madureira;Ubajara Mourato;Ubirajara Teves;Ubiratã Abranches;Ubiratã Cordero;Ubiratã Moreyra;Udo Bensaúde;Ulisses Medina;Valdeci Cordeiro;Valdeci Madruga;Valdemar Cachão;Valdemar Festas;Valentim Guedella;Valmor Covelhã;Valmor Quintas;Valmor Quiroga;Vasco Fróis;Veridiano Bautista;Veríssimo Caniça;Veríssimo Valladares;Vicente Covinha;Viridiano Castelo Branco;Viridiano Lameira;Viridiano Sotomayor;Vítor ou Victor Abranches;Vítor ou Victor Valiente;Xavier Cordeiro;Xerxes Covinha;Xisto Furtado;Xisto Salomón;Zacarias Bahía;Zuriel Maior;Álvaro Vidal;Átila Marreiro;Ângelo Lameira;Élvio Freire;Ítalo Valiente;Óscar Corvelo;Úrsula Pimenta;Úrsula Vilariça";
    private static final String WOMEN = "Adélia Jorge;Adélia Madruga;Aida Fontoura;Aida Manso;Aida Outeiro;Alberta Moreno;Alexandra Penteado;Alice Ipanema;Alicia Felgueira;Alicia Parente;Almerinda Carlos;Alzira Goes;Amália Mata;Amália Mortágua;Amélia Cotegipe;Amélia Macieira;Andreia Furquim;Angélica Guerrero;Aniana Cortés;Aniana Osório;Antonieta Pacheco;Antônia Cidreira;Antônia Ourique;Apoena Alencar;Apoena Linhares;Apoena Miguel;Araci Barreto;Araci Raminhos;Araci Álvez;Arminda Figueiró;Augusta Thamily;Aurélia Bulhões;Beatriz Hurtado;Belmira Barcelos;Belmira Cerqueira;Belmira Valverde;Benedita Negreiros;Berengária Dinis;Bernardete Buenaventura;Bernardete Casado;Bernardete Malheiros;Bernardete Quintela;Bernardina Canhão;Bibiana Queiroz;Brenda Sacadura;Brenda Vides;Bruna Estrela;Bruna Vilarim;Brígida Nieto;Burtira Guimaraens;Bárbara Cruz;Caetana Castelo Branco;Caetana Rebelo;Camila Bernárdez;Camila Cambezes;Camila Hidalgo;Carina Ventura;Carla Cruz;Carlota Moita;Carmem Pérez;Carminda Robalinho;Carolina Benevides;Catarina Bragança;Celeste Araújo;Celeste Campos;Celeste Lemes;Celina Raposo;Celina Rocha;Cidália Bezerril;Cidália Jaguariúna;Clara Lages;Clarisse Caldeira;Claudemira Dias;Cleusa Piteira;Clotilde Camargo;Clotilde Magallanes;Cláudia Pirajá;Conceição Prado;Cora Araripe;Cora Prada;Corina Guzmán;Cristiana Mendoza;Cristina Sabala;Cássia Esparteiro;Cátia Magallanes;Cândida Espartero;Cândida Nazário;Dalila Delgado;Dalila Mariz;Daniela Varão;Deise Pozas;Deise Quadros;Denise Telles;Deolinda Ferreira;Deolinda Marinho;Delfina Medeiros;Diana Pardo;Diana Rebouças;Dina Raposo;Dinarte Cayubi;Diodete Bulhosa;Diodete Modesto;Diodete Pajares;Diodete Santarém;Diodete Soeiro;Diodete Ávila;Donata Bello;Dora Damazio;Dora Gracia;Dora Soto;Doroteia Barrios;Doroteia Dutra;Doroteia Figueiró;Dulce Poças;Dália Mayor;Débora Amado;Délia Puerto;Eduarda Novaes;Elba Belchiorinho;Elba Cardozo;Elba Nieves;Elia Cabeza de Vaca;Elia Salgado;Elisa Corvelo;Elisa Rosmaninho;Elisa Sarmiento;Elisabete Baptista;Elsa Avelar;Elsa Guilheiro;Elvira Estévez;Elvira Mederos;Ema Leitão;Ema Veiga;Emanuela Ramos;Emiliana Coello;Emília Osório;Enilda Reguera;Epifânia Macedo;Ermelinda Figueroa;Ermelinda Santiago;Esmeralda Guedella;Esmeralda Mascarenhas;Esmeralda Valle;Esperança Caballero;Esperança Gaspar;Esperança Madeira;Esperança Vieira;Estela Borba;Estela Cardin;Estela Coelho;Estela Perdigón;Ester Ribas;Eugénia Jatobá;Eugénia Reyes;Eva Neres;Evangelista Ilha;Evangelista Lameirinhas;Evangelista Bacelar;Fabiana Amarante;Fabiana González;Feliciana Freiria;Felícia Almeida;Felícia Camello;Fernanda Nieves;Filena Villar;Filipa Guaraciaba;Filomena Abranches;Filomena Guedelha;Filomena Neres;Filomena Vidal;Firmina Gil;Firmina Machado;Flamínia Grangeia;Flamínia Sequera;Flor Alcaide;Flor Pimenta;Florbela Canadas;Florinda Durán;Florinda Ulhoa;Francisca Damásio;Frederica Alencar;Frederica Cascaes;Fábia Paraguaçu;Fátima Leiria;Gabriela Pais;Genoveva Reino;Genoveva Velázquez;Gertrudes Figueiroa;Gertrudes Lage;Gerusa Cayado;Gerusa Moreno;Gerusa Regalado;Gilda Castanheira;Gina Corrêa;Gina Pequeno;Gisela Monte;Gisela Parente;Gisela Velázquez;Gláucia Guarabira;Greice Sampaio;Guadalupe Cardim;Guadalupe Lira;Guadalupe Montenegro;Guadalupe Verissimo;Guaraci Ventura;Gueda Barrios;Gueda Leitão;Gueda Peralta;Guilhermina Asunción;Guilhermina Feitosa;Heloísa Jordão;Hermesinda Becerra;Hermesinda Caiapó;Hermesinda Horta;Hélia Athayde;Hélia Maranhão;Iara Laranjeira;Iberê Piteira;Ifigénia Eiró;Ifigénia Hurtado;Ilduara Leça;Ilma Beça;Ilma Eanes;Inaiá Fidalgo;Inês Mangueira;Iolanda Camilo;Iraci Castellano;Iraci Portela;Iraci Varella;Irani Castelbranco;Irene Freitas;Isaura Rolim;Isilda Estrella;Isilda Prada;Iva Pinho;Iva Talhão;Ivete Silvestre;Jaci Amado;Jaci Linhares;Jacinta Bezerra;Jacira Anjos;Jacira Galván;Janaína Trinidad;Jandaíra Fortunato;Jandira Melo;Joaquina Filipe;Joaquina Sarmiento;Jorgina Villela;Josefa Ipanema;Josefa Loio;Josefa Vides;Julieta Muñiz;Julieta Villena;Juçara Figueira;Juçara Liberato;Jéssica Caldera;Lara Mendoça;Lara Seabra;Lavínia Bethecourt;Lavínia Novalles;Leonilde Baptista;Leonilde Taborda;Leopoldina Mont'Alverne;Leopoldina Torquato;Letícia Casqueira;Letícia Téllez;Liliana Barcellos;Liliana Osorio;Liliana Tomé;Lua Marroquim;Luana Batista;Luana Butantã;Luciana Batista;Luciana Seixas;Lucrécia Tabares;Lucília Jardim;Lucília Ximenes;Luize Asunción;Luize Telles;Luize Verissimo;Luzia Guedez;Luísa Toledo;Léia Mena;Lídia Afonso;Lídia Barrocas;Lídia Novais;Lígia Sardinha;Lígia Veiga;Lília Abreu;Lúcia Galván;Lúcia Távora;Madalena Núñez;Madalena Valgueiro;Magali Bulhosa;Magda Jordão;Maiara Nieto;Maiara Tristão;Manuela Nieves;Margarida Figueiredo;Margarida Jesus;Maria Liberato;Mariana Cayado;Mariana Padilla;Mariana Rabello;Marilda Batata;Marilda Malheiro;Marina Barros;Marisa Brião;Marisa Hidalgo;Marta Dantas;Marta Lameiras;Marília Rego;Maíra Gil;Melissa Espartero;Melissa Feijó;Melissa Pitanga;Micaela Cisneros;Mileide Cayado;Mileide Javier;Mileide Pino;Mileide Rodovalho;Milena Dutra;Milu Lameirinhas;Miriam Domingos;Miriam Guimaraens;Miriam Javier;Moema Baranda;Morgana Barros;Máxima Canário;Mónica Briones;Mónica Fiães;Mônica Machado;Mônica Álvarez;Natacha Palhares;Natividade Bonilla;Natividade Meneses;Natália Figueira;Natália Filgueiras;Natália Rua;Nazaré Guimarães;Neuza Bahía;Neuza Vilas-Boas;Noêmia Goulart;Nádia Flores;Nádia Granjeiro;Nídia Jiménez;Ofélia Cisneiros;Ofélia Tavares;Olga Dias;Olga Pais;Ondina Borges;Ondina Fidalgo;Ondina Varanda;Oriana Vaz;Otília Beltrán;Pandora Toledo;Pandora Valle;Patrícia Bensaúde;Patrícia Eanes;Paula Vasconcelos;Penélope Hilário;Penélope Quintella;Piedade Carlos;Piedade Collaço;Piedade Gil;Poliana Freiria;Poliana Jiménez;Potira Monte;Potira Novais;Potira Queirós;Priscila Calheiros;Priscila Camello;Priscila Motta;Quirina Alcântara;Quirina Balsemão;Quirina Borba;Quirina Corvelo;Raquel Barateiro;Raquel Capanema;Raquel Peña;Raquel Sánchez;Rebeca Coitinho;Rebeca Negreiros;Regina Briones;Regina Caniça;Renata Quintão;Ricardina Nóbrega;Rita Ataíde;Roquita Belchior;Roquita Javier;Rosa Bivar;Rosa Delgado;Rosalina Guedez;Rosalina Melgaço;Rosalina Sobreira;Rosalinda Albuquerque;Rosalinda Bonilla;Rosaura Negrão;Rosaura Perdigão;Roseli Abranches;Roseli Garcez;Rute Araripe;Rute Coitinho;Rute López;Sabina Ataí;Sabrina Meira;Salvina Colares;Sancha Guaraciaba;Sandra Camacho;Sandra Chamusca;Sara Valverde;Sebastiana Belmonte;Sebastiana Domínguez;Sebastiana Pederneiras;Simone Angelim;Sofia Temes;Susana Canela;Susana Girão;Sônia Porciúncula;Sônia Vigário;Tainá Salles;Tainá Sant'Anna;Tairine Ornellas;Tatiana Valadares;Taíssa Brião;Telma Aranha;Telma Barcelos;Telma Palmeira;Telma Quirós;Telma Tristán;Teodora Bulhosa;Teresa Borges;Tânia Damazio;Tânia Mederos;Tânia Monjardim;Umbelina Carijó;Valentina Lóio;Valéria Chamusca;Vanda Carvalheira;Vanda Osorio;Vanda Sabrosa;Vanessa Alancastro;Vanessa Caldeira;Vanessa Gusmão;Vanessa Landim;Vanessa Pessoa;Virgínia Coutinho;Vitória Garcia de Gondim;Viviana Macena;Viviana Ulloa;Xénia Siebra;Xênia Pozas;Zara Carneiro;Zara Gomide;Zidane Jardim;Zilda Caldera;Zilda Souto;Zita Lucena;Zita Salomón;Zita Severiano;Zoe Moura;Zoe Valladares;Zoraide Gago;Zoraide Jácome;Zoraide Quintais;Zoraide Regalado;Zoraide Zalazar;Zubaida Marques;Ângela Alancastre;Ângela Caldas;Ângela Enríquez;Ângela Gutiérrez;Ângela Madruga;Énia Paes;Érica Feitosa;Érica Torrado;Íris Azenha;Íris Casado;Ítala Jatobá;Ítala Mirandela;Ítala Xavier";

    /**
     * Vetor contendo uma lista de nomes masculinos a serem sorteados aleatoriamente para
     * criar um aluno.
     */
    private static final String[] MEN_ARRAY = MEN.split(";");

    /**
     * Vetor contendo uma lista de nomes feminimos a serem sorteados aleatoriamente para
     * criar um aluno.
     */
    private static final String[] WOMEN_ARRAY = WOMEN.split(";");

    /**
     * Lista de campi em de uma instituição de ensino.
     */
    private static final Campus[] CAMPI = {
        new Campus(1, "Palmas"),
        new Campus(2, "Porto Nacional"),
        new Campus(3, "Paraíso do Tocantins"),
        new Campus(4, "Gurupi"),
        new Campus(5, "Araguaína")
    };

    /**
     * Gerador de números aleatórios.
     */
    private static final Random rand = new Random();

    /**
     * Gera uma lista aleatória de alunos.
     * Alguns alunos podem não ser matriculados em curso nenhum,
     * logo o atributo {@link Student#getCourse() course} será null.
     *
     * @param total total de alunos que deseja gerar
     * @return a lista de alunos gerados
     */
    public static List<Student> generate(final int total){
        final Course[] courses = {
                new Course(1, "Sistemas para Internet", 6, randCampus()),
                new Course(2, "Engenharia Elétrica", 10, randCampus()),
                new Course(3, "Engenharia Civil", 10, randCampus()),
                new Course(4, "Matemática", 8, randCampus()),
                new Course(5, "Educação Física", 8, randCampus()),
                new Course(6, "Gestão Pública", 6, randCampus())
        };

        System.out.printf("Gerando %d estudantes!\n", total);
        final List<Student> list = new ArrayList<>(total);
        for (int i = 1; i <= total; i++) {
            final char gender = randGender();
            list.add(new Student(i, randName(gender), gender, randScore(), randGradYear(), randCourse(courses, true)));
        }

        return list;
    }

    /**
     * Gera um nome aleatório.
     * @param gender sexo para obter um nome aleatório
     * @return
     */
    private static String randName(char gender){
        gender = Character.toUpperCase(gender);
        return gender == 'M' ? MEN_ARRAY[randInt(MEN_ARRAY.length)] : WOMEN_ARRAY[randInt(WOMEN_ARRAY.length)];
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
     *
     * @param courses Lista de cursos existentes
     * @param enableNull Se true, indica que pode ser retornado um curso null.
     *                   Atribuindo tal resultado a um aluno, indica que
     *                   ele não está matriculado em nenhum curso.
     * @return
     */
    private static Course randCourse(final Course[] courses, final boolean enableNull){
        if(enableNull){
            final int i = randInt(courses.length+1);
            return i < courses.length ? courses[i] : null;
        }

        return courses[randInt(courses.length)];
    }

    private static Campus randCampus(){
        return CAMPI[randInt(CAMPI.length)];
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
