create table t_time(
    id number generated by default as identity,
    nome varchar2(60),
    jogos number,
    vitorias number,
    empates number,
    gols_pro number,
    gols_contra number,
    primary key(id)
);

create table t_partida(
    id number generated by default as identity,
    id_timecasa number,
    id_timevisitante number,
    gols_casa number,
    gols_visitante number,
    primary key(id),
    foreign key (id_timecasa) references time(id),
    foreign key (id_timevisitante) references time(id)
);