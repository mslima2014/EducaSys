package com.tcc.professor.mapper;


import com.tcc.professor.DTO.AlunoDTO;
import com.tcc.professor.DTO.AlunoListDTO;
import com.tcc.professor.database.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoMapper {
    public static Aluno DTOtoEntity(AlunoDTO a){
        Aluno alu = new Aluno();
        alu.setCpf(a.getDc_cpf());
        alu.setRg(a.getDc_rg());
        alu.setDataN(null);
        alu.setEmail(a.getCo_email());
        alu.setTelefone(a.getCo_telefone());
        alu.setEndereco(a.getSt_endereco());
        alu.setNome(a.getSt_nome_aluno());
        alu.setId(0);
        alu.setUrl(a.getUrl_img_aluno());
        alu.setNomeP(a.getSt_nome_pai());
        alu.setNomeM(a.getSt_nome_mae());
        return alu;
    }

    public static AlunoDTO EntitytoDTO(Aluno a){
        AlunoDTO alu = new AlunoDTO();
        alu.setDc_cpf(a.getCpf());
        alu.setDt_data_nasc(null);
        alu.setCo_email(a.getEmail());
        alu.setSt_endereco(a.getEndereco());
        alu.setId_aluno(a.getId());
        alu.setDc_rg(a.getRg());
        alu.setSt_nome_aluno(a.getNome());
        alu.setPw_senha_aluno("");
        alu.setCo_telefone(a.getTelefone());
        alu.setUrl_img_aluno(a.getUrl());
        alu.setSt_nome_mae(a.getNomeM());
        alu.setSt_nome_pai(a.getNomeP());
        return alu;
    }

    public static List<AlunoListDTO> ListEntitytoListDTO(List<Aluno> list){

        List<AlunoListDTO> l2 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            l2.add(new AlunoListDTO(list.get(i).getId(),list.get(i).getNome(),list.get(i).getEmail(),list.get(i).getTelefone()));
        }

        return  l2;
    }
}
