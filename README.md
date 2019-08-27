El ejercicio fue hecho en MySQL

 path para continent por nombre:
 		/api/bryan/fromdb/name/{continentName}

 path para country por id:
 		/api/bryan/fromdb/id/{continentId}

 path para guardar un country:
 		/api/bryan/fromdb/save/country

 		Aquí es donde tengo un problema, al intentar guardar un Country, se puede guardar utilizando la funcion save() de spring data, cuando el id ya existe. De otra manera, el servidor manda error de hibernate que no puedo resolver. 