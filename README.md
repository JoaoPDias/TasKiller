## 3º Trabalho - DCC171

## Identificação

<table>
    <tr align = "center">
		<td><b>Nome</b></td>
        <td>
			João Paulo Dias 
		</td>
		<td>
			Pedro Fernandes Freitas
		</td>
		<td>
			Ricardo Furtado
		</td>
    </tr>
	<tr align = "center">
		<td><b>Matrícula</b></td>
        <td>
			201576017
		</td>
		<td>
			201576039
		</td>
		<td>
			201576038
		</td>
    </tr>
	<tr align = "center">
		<td><b>Curso</b></td>
        <td colspan = 3 >
				Sistemas de Informação
		</td>
    </tr>
</table>




## Objetivo do Sistema
O sistema foi desenvolvido para gerenciar os tarefas quanto a sua descrição, seu tempo de duração, seu percentual de conclusão,data de início, seu Status e previsão de conclusão, assim como seus requisitos, que são outras tarefas e seus colaborados. Cada tarefa faz parte de um projeto, este possuindo um nome. Há também a opção de cadastrar uma pessoa com nome e email e adicioná-la como colaborador de uma tarefa.Por fim ,há o dashboard que demonstra as tarefas do projeto e seus respectivos Status. 

## Esquema do Banco de Dados
O esquema de dados está disponível _na raíz do Projeto_ e _no link_: [https://1drv.ms/i/s!AoXjPyyJW_sygYcMMNKfcFqKYd-maQ](https://1drv.ms/i/s!AoXjPyyJW_sygYcMMNKfcFqKYd-maQ "Esquema do Banco de Dados")

O esquema construído busca abordar os requisitos do sistema. Todas as tabelas possuem chaves primárias. Tarefa, Pessoa, Projeto são chaves autoincrementáveis e Tarefa_Pessoa e Requisito são chaves compostas de duas chaves estrangeiras.

Um projeto possui N tarefas, sendo assim, cada registro da tarefa possuirá o campo chave estrangeira fkProjeto representando esse relacionamento. Há um autorrelacionamento de Tarefa com Requisito, já que N tarefas podem ter N tarefas como requisitos. Assim, a tabela requisito apresenta como chave primária, **a chave da Tarefa e a chave de seu requisito** e um campo boolean **Concluido** para sinalizar a conclusão do requisito. A Tarefa pode possuir N colaboradores, assim como um colaboradores pode estar em N tarefas, sendo necessária a tabela **tarefa_pessoa** para gerenciar esse relacionamento N para N entre Tarefa e Pessoa. A Pessoa possui ,como campos do registro, o nome e o e-mail. 

## Modelo de Classes

Para modelar as classes bases do sistema foram criadas 3 classes. Projeto, Tarefa e Pessoa.
A Classe Projeto, além do seu id, nome e e-mail apresenta uma coleção de tarefas para facilitar o acesso aos dados do projeto no DashBoard, assim como na classe Tarefa há uma coleção de Requisitos, no caso da classe Tarefa e de Colaboradores, no caso pessoas. Para ser demonstrado os requisitos existentes para poder desbloquear a tarefa e oss colaboradores cadastrados presentes na tarefa. A classe Pessoa possui os dados da pessoa e a lista de tarefas designadas à pessoa, Podendo assim facilitar a implementação futura de um sistema de login e separação por usuário do DashBoard. A nível de projeto foram adicionadas classes DAO para acessar o banco de dados e gravar o objeto. O modelo das entidades base do sistema está disponível _na raíz do Projeto e no link_: [https://1drv.ms/i/s!AoXjPyyJW_sygYsnm8OTOWT6J8BcQg]


## Pontos onde podem ser realizadas melhorias futuras

A interface necessita de melhorias quanto a implementação de atalhos, a sinalização de tarefas concluídas na tabela de tarefas e melhorias gerais que buscam adequar o sistema aos padrões usados em sistemas desktop. O foco ao novo dado inserido na tabela, permitindo ao usuário a visualização do resultado de sua operação. Assim como a possibilidade de mudar uma tarefa de status movendo-a pelo Dashboard que ,nessa primeira versão, é estático, só resume o que está cadastrado no sistema.
