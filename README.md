# Quero ser MB

Somos a maior plataforma de negociação de criptomoedas e ativos alternativos da América Latina, criada para elevar a experiência de quem vivencia essa revolução, entregando o melhor serviço de negociação de ativos alternativos, com liberdade, segurança e liquidez. Sendo assim, nós existimos para mudar a maneira como as pessoas lidam com o dinheiro através da tecnologia.

### Objetivo

O objetivo deste desafio é entender seus conhecimentos, estilo de programação e como você resolve desafios técnicos.

### Projeto
Criar um aplicativo para consultar a [coinapi.io](https://docs.coinapi.io/?shell#list-all-exchanges-get) e trazer as exchanges em forma de lista.

### Credencial da API
Será necessária uma [API_KEY](https://www.coinapi.io/get-free-api-key?product_id=market-data-api) para utilizar a API.


### Features
-   **Tela de listagem:**
    - Exibir, pelo menos, os campos: `name`, `exchange_id` e `volume_1day_usd`
    - Ao tocar em um item deve ser exibida a tela de detalhes.
-   **Tela de detalhe:**
    - Exibe os detalhes da exchange.

### Requisitos Técnicos
|      Android       |     iOS            |
| ------------------ | ------------------ |
| Kotlin             |  Swift 5+          |
| Compose            |  View Code         |
| Testes unitários   |  Testes unitários  |
| Testes de UI       |  Testes de UI      |

#### Arquitetura

Sinta-se à vontade para utilizar a arquitetura que melhor atender o projeto proposto. Aqui no Mercado Bitcoin utilizamos 

|      Android       |     iOS            |
| ------------------ | ------------------ |
| MVVM com Clean     |  MVVM-C e VIP-C    | 

### Requisitos não funcionais

- UI e UX fluída seguindo os padrões da plataforma.
- A aplicação deve ser resiliente, tratamento de erros são bem-vindos.
- Considerar escalabilidade.

### Prazo
A partir do envio do desafio ao candidato por e-mail, o prazo de retorno é de 7 dias corridos.

### Processo de Submissão
O candidato deverá enviar a solução por e-mail contendo todas instruções necessárias para executá-lo, em formato .zip.

### IMPORTANTE
Esse código não será usado em nenhuma hipótese para qualquer fim a não ser o de avaliação de conhecimentos técnicos.

## A Solução e considerações sobre o projeto

A aplicação se trata de uma listagem de exchanges utilizando-se da API da **[CoinAPI.io](https://www.coinapi.io/)** para obter os dados.

- **OBS:** A branch **master** contém uma abordagem utilizando visualização com XML e se diferencia com a DI Koin. Já a branch **dev** utiliza a estrura
de visualização com **Jetpack Compose e DI Hilt**.
- Alguns dados estavam indisponíveis, estão foi adotado *placeholders* com a logo do Digio para imagens não disponíveis.

Foi adotada a **[Arquitetura MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)** de acordo com as [recomendações de arquitetura mobile da Google](https://developer.android.com/jetpack/guide) juntamente com a **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)**. Além disso, foi adotado no projeto as principais bibliotecas do mundo do [Android Jetpack](https://developer.android.com/jetpack) e utilização de demais ferramentas. Seguem abaixo as principais bibliotecas utilizadas:

- **[Retrofit](https://square.github.io/retrofit/) + [OkHttp:](https://square.github.io/okhttp/)** clientes HTTP *type-safety* para Android de fácil utilização que fornece um simples padrão de implementação para transmissão de dados entre aplicação/servidor que também nos auxiliam a "cachear" informações.
- **[Kotlin Coroutines + Flow:](https://developer.android.com/kotlin/flow)** um tipo que pode emitir vários valores sequencialmente, ao contrário das funções de suspensão, que retornam somente um valor. fluxos são criados com base nas corrotinas e podem fornecer vários valores. Conceitualmente, um fluxo é um stream de dados que pode ser computado de forma assíncrona.
- **[Hilt:](https://dagger.dev/hilt/)** O Hilt fornece uma maneira padrão de incorporar a injeção de dependência do Dagger em um aplicativo Android.
- **[Navigation:](https://developer.android.com/guide/navigation)** o componente de navegação do Android Jetpack ajuda você a implementar a navegação, desde simples cliques em botões até padrões mais complexos, como barras de aplicativos e a gaveta de navegação. Esse componente também garante uma experiência do usuário consistente e previsível por meio da adesão a um conjunto de princípios estabelecido.
- **[Jetpack Compose:](https://developer.android.com/jetpack/compose)** o Jetpack Compose é um kit de ferramentas moderno do Android para criar IUs nativas. Ele simplifica e acelera o desenvolvimento da IU no Android, tornando o código mais simples e fácil de manter (evita codificação de classes e códigos *boilerplates*). Trabalha de forma declarativa, o que acelera o desenvolvimento.
- **[Mockk:](https://mockk.io/)** uma biblioteca para simulação escrito e feito para o Kotlin + JUnit 4 (o JUnit 4 expõe uma API baseada em regras para permitir alguma automação após o ciclo de vida do teste).

Por fim, falando um pouco sobre o **MVVM (Model-View-ViewModel)**, temos basicamente a divisão em:

- **Model:** a camada que encapsula a lógica de negócios e os dados. Nada mais é do que o modelo de domínio de uma aplicação.
- **View:** tem por responsabilidade definir a aparência ou estrutura que o usuário vê na tela. Se trata de toda a parte visual da aplicação.
- **ViewModel:** sua incumbência é disponibilizar para a camada de *View* uma lógica de apresentação. A *ViewModel* não tem nenhum conhecimento específico sobre a view, apenas implementa propriedades e comandos e notifica a *View* no caso de alterações. Ela permite que os dados sobrevivam às mudanças de configurações, como a rotação de tela, por exemplo.

Considerando estas camadas, podemos observar que é uma divisão que se encaixa diretamente com a **Clean Architecture**, que consiste em um diagrama de camadas, onde cada um dos seus componentes possuem suas próprias responsabilidades e cada uma delas tem conhecimento apenas de camadas mais internas. Isso traz consigo várias vantagens:

- o código é facilmente testável.
- componentes ainda mais desacoplados, a estrutura do pacote é facilmente de se navegar entre eles.
- novas funcionalidades podem ser adicionadas rapidamente pelo time de desenvolvedores.

Cada camada de MVVM usando Clean Architecture no Android e os códigos se dividem em três camadas:

- **Camada de Apresentação (Presentation Layer):** Nesta camada, são incluídas as "Activity"s, "Fragment"s como sendo as "Views", e as "ViewModel"s, devem ser mais simples e intuitivo possível e ainda, não devem ser incluídas regras de negócio nas "Activity"s e "Fragment"s. Uma "View" irá se comunicar com sua respectiva "ViewModel", e assim, a "ViewModel" se comunicará com a camada de domínio para que sejam executadas determinadas ações. Uma "ViewModel" nunca se comunicará diretamente com a camada de dados. Aqui, na estrutura de nosso projeto, temos os diretórios "presentation", que por sua vez, possui os diretórios "ui" (com nossas "View"s e "ViewModel"s) e "di" (com nosso módulo Koin para tratar as injeções de dependência).

- **Camada de Domínio (Domain Layer):** Na camada de domínio, devem conter todos os casos de uso da aplicação. Os casos de uso tem como objetivo serem mediadores entre suas "ViewModel"s e os "Repository"s. Caso for necessário adicionar uma nova funcionalidade, tudo o que deve ser feito é adicionar um novo caso de uso e todo seu respectivo código estará completamente separado e desacoplado dos outros casos de uso. A criação de um novo caso de uso é justamente para evitar que ao adicionar novas funcionalidades, quebrar as preexistentes no código. Podemos observar o diretório "domain" e, neste, o diretório "usecase" com todos os nossos casos de uso.

- **Camada de Dados (Data Layer):** Esta camada possui todos os repositórios que a camada de domínio tem disponíveis para utilização e "DataSource"s, que são responsáveis por decidir qual a fonte em que devem ser recuperados os dados, sendo de uma base de dados local ou servidor remoto. Note o repositório "data". Nele se concentra nossos modelos de dados, modelagem do banco de dados, camada de serviço (que lista todos os nosso endpoints), camada de DAO para acesso aos dados no banco e, a parte dos nossos repositórios.

Por fim, como temos uma aplicação simples, centralizamos todo o código em um **único módulo**. Porém, a estrutura do projeto está construída para facilmente podermos escalá-lo - como justificamos acima - em casos de features futuras, como por exemplo, podemos isolar os packages **core** (centralizando analytics e configurações de network) e **commons** (componente, extensions, base components, etc.) como outros módulos centrais ao projeto para serem utilizados por todo o projeto.

Desde já, grato. Segue evidências do app.

<img width="200" alt="Captura de Tela 2025-02-17 às 11 55 36" src="https://github.com/user-attachments/assets/98e5c925-ffcb-4731-839c-fb81d661ce3b" />
<img width="200" alt="Captura de Tela 2025-02-17 às 15 21 31" src="https://github.com/user-attachments/assets/ed44eb0d-caf7-448a-a9d1-ee7e61b787eb" />
<img width="200" alt="Captura de Tela 2025-02-17 às 11 55 24" src="https://github.com/user-attachments/assets/b6a19ea4-377d-47dc-8dfb-24f8020bca41" />


**Autor: Lucas Christopher.**

##### _Toda honra e toda glória seja dada ao Rei dos Reis: JESUS!_
