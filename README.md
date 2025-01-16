# Sistema de Controle de Assinaturas de Aplicativos (SCAA)
Descrição
Este projeto é a implementação de um sistema de controle de assinaturas de aplicativos (SCAA) para uma startup fictícia que trabalha com um modelo de negócio baseado em assinaturas mensais para aplicativos móveis. O sistema tem como objetivo gerenciar os aplicativos oferecidos, os clientes, as assinaturas, os pagamentos e a validade das assinaturas. O projeto foi desenvolvido em duas partes:

Parte 1: Desenvolvimento do sistema como um backend monolítico utilizando a arquitetura CLEAN.
Parte 2: Refatoração do sistema para utilizar microsserviços, com a criação de um novo microsserviço, o AssCache, para melhorar a performance e permitir a comunicação entre o SCAA e o AssCache através de filas.
Funcionalidades
Parte 1 - Backend Monolítico
O sistema backend foi desenvolvido utilizando a arquitetura CLEAN e oferece as seguintes funcionalidades:

Cadastro de aplicativos: Cadastro, edição e listagem de aplicativos disponíveis no sistema.
Cadastro de clientes: Cadastro, edição e listagem de clientes que podem assinar os aplicativos.
Cadastro de assinaturas: Permite que um cliente assine um aplicativo, gerando um código de assinatura e associando-o ao cliente e ao aplicativo.
Atualização de custo de aplicativos: Atualização do valor mensal da assinatura de um aplicativo.
Validação de assinatura: Responde se uma assinatura está ativa ou não, conforme a data de validade.
Listagem de assinaturas: Listagem das assinaturas de um cliente ou de um aplicativo.
Notificação de pagamento: Recebe notificações de pagamento de assinaturas e atualiza a data de validade.
Parte 2 - Microsserviço AssCache
A segunda parte do projeto envolveu a refatoração do sistema para uma arquitetura de microsserviços, com a introdução do microsserviço AssCache, com as seguintes características:

Objetivo: O AssCache armazena em cache as informações de validade das assinaturas para melhorar a performance, respondendo rapidamente às consultas dos aplicativos sobre a validade das assinaturas.
Comunicação síncrona com o SCAA: Quando o AssCache não possui a informação sobre a validade de uma assinatura, ele faz uma consulta síncrona ao SCAA e armazena a informação em cache para consultas futuras.
Comunicação entre microsserviços: O SCAA envia notificações para o AssCache sobre atualizações de assinaturas através de filas, garantindo que todas as instâncias do AssCache recebam as atualizações.
Tecnologias Utilizadas
Backend Monolítico (Parte 1):
Java 17
Spring Boot
PostgreSQL
Arquitetura CLEAN
Microsserviço AssCache (Parte 2):
Java 17
Spring Boot
Redis (para cache)
RabbitMQ (para comunicação entre microsserviços via filas)
Endpoints
Parte 1 - Endpoints do SCAA
GET /servcad/clientes: Lista todos os clientes cadastrados.
GET /servcad/aplicativos: Lista todos os aplicativos cadastrados.
POST /servcad/assinaturas: Cria uma assinatura para um cliente e aplicativo.
POST /servcad/aplicativos/atualizacusto/:idAplicativo: Atualiza o custo de assinatura de um aplicativo.
GET /servcad/assinaturas/{tipo}: Lista as assinaturas com status especificado (ATIVAS, CANCELADAS, TODAS).
GET /servcad/asscli/:codcli: Lista as assinaturas de um cliente específico.
GET /servcad/assapp/:codapp: Lista as assinaturas de um aplicativo específico.
POST /registrarpagamento: Registra um pagamento de uma assinatura.
GET /assinvalida/:codass: Verifica se uma assinatura continua válida.
Parte 2 - Microsserviço AssCache
O AssCache é responsável por fornecer a validade da assinatura de forma rápida. Ele faz cache das informações de validade e consulta o SCAA de forma síncrona caso a informação não esteja em cache.

GET /cache/assinatura/{codass}: Consulta a validade de uma assinatura. Se a informação não estiver em cache, consulta o SCAA e armazena em cache para futuras consultas.
