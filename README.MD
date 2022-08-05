# Imagem-Quote API

Projeto desenvolvido para o último desafio de projeto do módulo de Spring Framework do Santander Bootcamp Fullstack Developer da DIO.

Modificado o projeto demonstrado pelo professor Venilton Falvo Jr, fiz um projeto que cria templates com um título, uma url de imagem e uma quote de inspiração. A ideia seria colocar imagens cômicas, que contrastariam com a natureza séria das quotes que as acompanhariam, fazendo posteriormente um front-end que possa consumir esses dados e os exiba conjuntamente.

Foi mantido o esquema de dois repositórios do professor, sendo um deles alimentado por outra API. Como o acesso dela é relativamente limitado, busquei armazenar as quotes que foram sendo geradas num repositório para, caso queira utilizar uma quote já utilizada (em vez de fazer de forma aleatória), não precisar chamar a API novamente. Para isso, foi adotado como ID a própria quote, removidos os espaços e outros sinais de pontuação.

Gostaria de ter tido mais tempo de desenvolver o projeto, mas sem dúvidas foi uma ótima oportunidade de praticar os conceitos estudados no módulo de Spring Framework.