package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.dto.ProjectDto;
import com.caner.issuemanagement.entity.Project;
import com.caner.issuemanagement.service.ProjectService;
import com.caner.issuemanagement.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public  ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public Project save(Project project) {
        if(project.getProjectCode()==null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
